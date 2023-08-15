package com.koscom.kosletter.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_research")
public class CompanyResearch {
    @Id
    private long id;
    private String code;
    private String statImg;
    private String predImg;
    private String tableImg;
}
