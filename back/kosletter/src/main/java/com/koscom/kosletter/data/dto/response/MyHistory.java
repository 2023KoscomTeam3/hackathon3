package com.koscom.kosletter.data.dto.response;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyHistory {
    private long historyId;
    private String stockName;
    private String correctness;
    private LocalDate date;
}
