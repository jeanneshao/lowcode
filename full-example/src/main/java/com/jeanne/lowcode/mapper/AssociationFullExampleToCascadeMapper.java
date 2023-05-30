package com.jeanne.lowcode.mapper;

import com.jeanne.lowcode.entity.AssociationFullExampleToCascade;
import com.jeanne.lowcode.utils.MybatisRedisCache;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 实体和文件关联表 Mapper 接口
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Mapper
@CacheNamespace(implementation= MybatisRedisCache.class,eviction=MybatisRedisCache.class)
public interface AssociationFullExampleToCascadeMapper extends BaseMapper<AssociationFullExampleToCascade> {

}
