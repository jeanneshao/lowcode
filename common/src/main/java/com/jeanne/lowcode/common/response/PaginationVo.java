package com.jeanne.lowcode.common.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author Jeanne 2023/5/24
 **/
@Data
@Builder
public class PaginationVo {
    private Long page = 0l;
    private Long rowsPerPage = 10l;
    private Long rowsNumber = 10l;//后台分页需要加上这俩
    private Long pageCount = 0l;
    private Boolean descending = true;
}
