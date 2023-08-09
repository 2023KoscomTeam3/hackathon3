package com.koscom.kosletter.data.repository;

import com.koscom.kosletter.data.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmailAndPassword(String email, String password);
    List<Member> findTop10ByOrderByCoinDesc();
}
