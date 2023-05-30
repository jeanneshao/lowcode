package com.jeanne.lowcode.mapperstruct;

import com.jeanne.lowcode.entity.FullExample;
import com.jeanne.lowcode.entity.LowcodeEnum;
import com.jeanne.lowcode.vo.FullExampleVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Qualifier;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Jeanne 2023/5/22
 **/
@Mapper
public interface LowcodeEnumStructMapper {
    LowcodeEnumStructMapper INSTANCE = Mappers.getMapper(LowcodeEnumStructMapper.class);


}
