package com.jeanne.lowcode.mapper;

import com.jeanne.lowcode.dto.OneToManyExampleDto;
import com.jeanne.lowcode.dto.OneToOneExampleDto;
import com.jeanne.lowcode.entity.OneToOneExample;
import com.jeanne.lowcode.utils.MybatisRedisCache;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 一对一的关联表 Mapper 接口
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Mapper
@CacheNamespace(implementation= MybatisRedisCache.class,eviction=MybatisRedisCache.class)
public interface OneToOneExampleMapper extends BaseMapper<OneToOneExample> {
    @Select("SELECT id,name FROM one_to_one_example WHERE id = #{id}")
    OneToOneExampleDto selectIdNameFromOneToOneExample(Long id);
}
