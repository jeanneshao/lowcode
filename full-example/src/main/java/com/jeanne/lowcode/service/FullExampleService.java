package com.jeanne.lowcode.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jeanne.lowcode.entity.FullExample;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jeanne.lowcode.vo.FullExampleVo;
import com.jeanne.lowcode.common.response.PaginationVo;
import com.jeanne.lowcode.vo.TextSearchVo;

import java.util.Map;

/**
 * <p>
 * entry resource 服务类
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
public interface FullExampleService extends IService<FullExample> {
    FullExampleVo getFullExampleById(Long id);

    String saveOrUpdate(FullExampleVo fullExampleVo);

    IPage<FullExample> search(TextSearchVo fullExampleVo, PaginationVo paginationVo, String sortProperties);
}
