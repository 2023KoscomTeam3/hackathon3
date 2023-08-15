package com.koscom.kosletter.data.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Ranking {
    private String nickname;
    private int coin;
}
