package com.koscom.kosletter.data.repository;

import com.koscom.kosletter.data.dto.response.InterestStock;
import com.koscom.kosletter.data.entity.Member;
import com.koscom.kosletter.data.entity.Stock;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("select "
        + "new com.koscom.kosletter.data.dto.response.InterestStock(s.id, s.name, s.picture) "
        + "from Interest i "
        + "left join fetch Stock s on i.stock = s.id "
        + "where i.member = :member")
    List<InterestStock> getInterestStock(@Param("member") Member member);

    Stock getByCode(String stockCode);
    Stock findByName(String stockName);
}
