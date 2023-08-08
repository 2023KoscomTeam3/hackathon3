package com.koscom.kosletter.data.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockInfo {
    private long stockId;
    private String name;
}
