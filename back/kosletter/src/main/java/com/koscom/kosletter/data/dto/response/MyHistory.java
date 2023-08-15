package com.koscom.kosletter.data.dto.response;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyHistory {
    private long historyId;
    private String stockName;
    private Integer difPrice;
    private LocalDate date;
    private Long price;
    private long predictPrice;
    private String result;

}
