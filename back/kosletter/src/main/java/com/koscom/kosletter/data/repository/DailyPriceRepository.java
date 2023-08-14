package com.koscom.kosletter.data.repository;

import com.koscom.kosletter.data.entity.DailyPrice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyPriceRepository extends JpaRepository<DailyPrice, Long> {
    List<DailyPrice> findTop2ByCompanyOrderByDateDesc(String company);
}
