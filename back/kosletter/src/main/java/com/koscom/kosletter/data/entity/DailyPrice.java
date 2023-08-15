package com.koscom.kosletter.data.entity;

import java.time.LocalDate;
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
@Table(name = "top50_daily_price")
public class DailyPrice {
    @Id
    private long id;
    private String code;
    private String company;
    private LocalDate date;
    private Long close;
}
