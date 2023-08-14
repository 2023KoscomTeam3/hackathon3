package com.koscom.kosletter.data.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private int vote;
    @Column(nullable = false)
    private LocalDate date;
    @Column(columnDefinition="tinyint(1)")
    private boolean correctness;
    //맞으면 2, 틀리면 1
    @ColumnDefault("0")
    private int correct;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "stock_id")
//    private Stock stock;
    @Column(name = "stock_id")
    private long stock;
}
