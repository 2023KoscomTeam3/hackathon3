package com.koscom.kosletter.data.repository;

import com.koscom.kosletter.data.entity.News;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByCode(String code);
}
