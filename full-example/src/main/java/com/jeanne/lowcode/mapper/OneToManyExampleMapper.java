package com.jeanne.lowcode.mapper;

import com.jeanne.lowcode.dto.OneToManyExampleDto;
import com.jeanne.lowcode.entity.OneToManyExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 一对多的关联表 Mapper 接口
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Mapper
public interface OneToManyExampleMapper extends BaseMapper<OneToManyExample> {
    @Select("SELECT id,name FROM one_to_many_example WHERE full_example_id = #{fullExampleId}")
    List<OneToManyExampleDto> selectOneToManyByFullExampleId(Long fullExampleId);

}
