package com.jeanne.lowcode.vo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeanne 2023/5/24
 **/
@Data
@Builder
public class TextSearchVo {
    List<SearchIem> searchIemList = new ArrayList<>();

    @Builder
    @Data
    public static class SearchIem {
        private String field;
        private String operator;
        private String[] params;
    }

}

