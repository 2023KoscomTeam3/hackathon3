package com.koscom.kosletter.data.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyStockRequest {
    private long memberId;
    private long stockId;
}
