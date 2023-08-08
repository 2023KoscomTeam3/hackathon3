package com.koscom.kosletter.data.repository;

import com.koscom.kosletter.data.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    boolean existsByMember_IdAndStock_Id(long memberId, long stockId);
    void deleteByMember_IdAndStock_Id(long memberId, long stockId);
}
