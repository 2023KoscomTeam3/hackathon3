package com.koscom.kosletter.data.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Table(name = "company_news")
public class CompanyNews {
    @Id
    private long id;
    private String code;
    @Column(columnDefinition = "LONGTEXT")
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private String link;
}
