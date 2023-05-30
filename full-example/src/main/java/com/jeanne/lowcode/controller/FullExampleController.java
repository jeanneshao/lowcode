package com.jeanne.lowcode.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jeanne.lowcode.common.response.BizResponse;
import com.jeanne.lowcode.entity.FullExample;
import com.jeanne.lowcode.interceptors.access.AccessLimit;
import com.jeanne.lowcode.interceptors.query.ConvertQueryParam;
import com.jeanne.lowcode.service.FullExampleService;
import com.jeanne.lowcode.vo.FullExampleVo;
import com.jeanne.lowcode.common.response.PaginationVo;
import com.jeanne.lowcode.vo.TextSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * entry resource 前端控制器
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Controller
@RequestMapping(path = "/fullExample")
@Slf4j
public class FullExampleController extends BaseEntityController {
    @Autowired
    FullExampleService fullExampleService;

    @GetMapping()
    @ConvertQueryParam
    public BizResponse search(TextSearchVo textSearchVo, PaginationVo paginationVo, @RequestParam("sortProperties") String sortProperties) {
        IPage<FullExample> fullExampleIPage = fullExampleService.search(textSearchVo, paginationVo, sortProperties);
        return  BizResponse.pageSuccess(fullExampleIPage);
    }

    @GetMapping("test/{id}")
    @AccessLimit
    public BizResponse tttest(@PathVariable Long id, @RequestParam Map fullExampleVo){
        log.info("<=====================tttest controller===========================>");
        return  BizResponse.success("success");
    }

    @PostMapping
    public BizResponse save(@RequestBody FullExampleVo fullExampleVo) {

        fullExampleService.saveOrUpdate(fullExampleVo);
        return  BizResponse.success("success");
    }

    @GetMapping(path = "/{id}")
    public BizResponse getById(@PathVariable Long id) {
        FullExampleVo fullExampleVo = fullExampleService.getFullExampleById(id);
        return BizResponse.success(fullExampleVo);
    }

    @GetMapping(path = "/err")
    public BizResponse stimulateError() {
        int result = 100/0;
        return BizResponse.success(result);
    }



}
