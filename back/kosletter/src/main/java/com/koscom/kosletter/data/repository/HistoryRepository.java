package com.koscom.kosletter.data.repository;

import com.koscom.kosletter.data.entity.History;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query("select count(h.member) from History h where h.member.id=:memberId")
    int getHistoryCountByMemberId(@Param("memberId") long memberId);

    @Query("select count(h.member) from History h where h.member.id=:memberId and h.correct=0")
    int getHistoryCorrectCountByMemberId(long memberId);

    List<History> getByDateAndCorrectIsNull(LocalDate date);

    List<History> getByMember_Id(long id);
    boolean existsByMember_IdAndStockAndDate(long memberId, long stockId, LocalDate date);
  
}
