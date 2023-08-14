package com.koscom.kosletter.data.repository;

import com.koscom.kosletter.data.entity.DailyPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyPriceRepository extends JpaRepository<DailyPrice, Long> {
    DailyPrice findTop2ByCompanyOrderByDateDesc(String company);
}
