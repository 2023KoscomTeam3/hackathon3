package com.koscom.kosletter.data.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RankListResponse {
    private List<Ranking> ranking;
}
