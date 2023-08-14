package com.koscom.kosletter.data.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "top50_company")
public class Stock {
    @Id
    private long id;
    @Column(name = "code")
    private String code;
    @Column(name = "company")
    private String name;
    @Column(nullable = false)
    private String picture;
    @Column
    private int price;
    @Column(name = "last_update")
    private LocalDate date;
}
