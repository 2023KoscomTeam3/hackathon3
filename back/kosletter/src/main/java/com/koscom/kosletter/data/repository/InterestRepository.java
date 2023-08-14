package com.koscom.kosletter.data.repository;

import com.koscom.kosletter.data.dto.response.SendEmailRequest;
import com.koscom.kosletter.data.entity.Interest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    boolean existsByMember_IdAndStock(long memberId, long stockId);
    void deleteByMember_IdAndStock(long memberId, long stockId);

//    @Query("select "
//        + "new com.koscom.kosletter.data.dto.response.SendEmailRequest(m.email, m.nickname, s.name, n.title, n.contents, n.url) "
//        + "from Interest i "
//        + "left join fetch Member m on i.member.id = m.id "
//        + "left join fetch Stock s on i.stock.id = s.id "
//        + "left join fetch News n on s.name = n.stockName")
//    List<SendEmailRequest> getMemberStocks();
}
