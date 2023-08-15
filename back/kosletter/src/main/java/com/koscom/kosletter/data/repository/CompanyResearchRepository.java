package com.koscom.kosletter.data.repository;

import com.koscom.kosletter.data.entity.CompanyResearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyResearchRepository extends JpaRepository<CompanyResearch, Long> {
    CompanyResearch getByCode(String code);
}
