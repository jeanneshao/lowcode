package com.jeanne.lowcode.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author Jeanne 2023/5/24
 **/
@Data
@Builder
public class SortVo{
    private Boolean asc = true;
    private String sortProperty = "";
}

