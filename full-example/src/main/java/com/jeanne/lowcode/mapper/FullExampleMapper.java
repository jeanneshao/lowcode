package com.jeanne.lowcode.mapper;

import com.jeanne.lowcode.entity.FullExample;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

/**
 * <p>
 * entry resource Mapper 接口
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Mapper
@InterceptorIgnore
public interface FullExampleMapper extends BaseMapper<FullExample> {
    FullExample getFullExampleById(@Param("id") Long id);
}
