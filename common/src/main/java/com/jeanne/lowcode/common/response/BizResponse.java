package com.jeanne.lowcode.common.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
public class BizResponse<T> {
    private int code = 200;
    private String msg;
    private T data;
    private List<T> records;
    private PaginationVo pagination;

    public static <T> BizResponse<T> pageSuccess(IPage<T> data) {
        PaginationVo paginationVo = PaginationVo.builder()
                .page(data.getCurrent() + 1)
                .rowsPerPage(data.getSize())
                .rowsNumber(data.getTotal())
                .pageCount(data.getPages())
                .build();
        log.info("pageSuccess===>{}",paginationVo);

        return new BizResponse<T>(data.getRecords(),paginationVo);
    }

    public static <T> BizResponse<T> success(T data) {
        return new BizResponse<T>(data);
    }


    public static <T> BizResponse<T> error(CodeMsg cm) {
        return new BizResponse<T>(cm);
    }

    public BizResponse() {

    }

    private BizResponse(T data) {
        this.msg = "success";
        this.data = data;
    }

    private BizResponse(List<T> records,PaginationVo paginationVo) {
        log.info("BizResponse===paginationVo=====>{}",paginationVo);
        this.msg = "success";
        this.records = records;
        this.pagination=paginationVo;
    }

    private BizResponse(CodeMsg cm) {
        if (cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
