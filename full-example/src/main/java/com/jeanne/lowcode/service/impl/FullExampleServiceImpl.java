package com.jeanne.lowcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jeanne.lowcode.entity.FullExample;
import com.jeanne.lowcode.mapper.FullExampleMapper;
import com.jeanne.lowcode.mapperstruct.FullExampleStructMapper;
import com.jeanne.lowcode.service.FullExampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeanne.lowcode.utils.LowcodeQueryHelper;
import com.jeanne.lowcode.vo.FullExampleVo;
import com.jeanne.lowcode.common.response.PaginationVo;
import com.jeanne.lowcode.vo.TextSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * entry resource 服务实现类
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Service
@Slf4j
public class FullExampleServiceImpl extends ServiceImpl<FullExampleMapper, FullExample> implements FullExampleService {

    @Resource
    FullExampleMapper fullExampleMapper;

    public FullExampleVo getFullExampleById(Long id){
        log.info("FullExampleServiceImpl getFullExampleById");
        FullExample fullExample = fullExampleMapper.getFullExampleById(id);
        FullExampleVo fullExampleVo = FullExampleStructMapper.INSTANCE.map(fullExample);

        return fullExampleVo;
    }
    public String saveOrUpdate(FullExampleVo fullExampleVo){
        FullExample fullExample = FullExampleStructMapper.INSTANCE.map(fullExampleVo);
        boolean success = saveOrUpdate(fullExample);
        return success?"Success":"Failure";
    }

    public IPage<FullExample> search(TextSearchVo textSearchVo, PaginationVo paginationVo, String sortProperties){

        IPage<FullExample> page = LowcodeQueryHelper.convertPagination(paginationVo);

        QueryWrapper<FullExample>  queryWrapper =  LowcodeQueryHelper.obtainCriteria(sortProperties, textSearchVo, FullExample.class);

        return fullExampleMapper.selectPage(page, queryWrapper);
    }


}
