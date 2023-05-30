package com.jeanne.lowcode.mapperstruct;

import com.jeanne.lowcode.entity.FullExample;
import com.jeanne.lowcode.mapperstruct.qualifiers.LowcodeEnumQualifiers;
import com.jeanne.lowcode.mapperstruct.qualifiers.OneToOneExampleQualifiers;
import com.jeanne.lowcode.vo.FullExampleVo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

/**
 * @author Jeanne 2023/5/22
 **/
@Mapper(uses = {LowcodeEnumQualifiers.class, OneToOneExampleQualifiers.class })
public interface FullExampleStructMapper {
    FullExampleStructMapper INSTANCE = Mappers.getMapper(FullExampleStructMapper.class);


    @Mapping(source = "cogWithEnum", target = "cogWithEnumOptions", qualifiedBy = LowcodeEnumQualifiers.IdMapper.class, nullValueCheckStrategy = ALWAYS)
    @Mapping(source = "cogWithEnum", target = "cogWithEnumName", qualifiedBy = LowcodeEnumQualifiers.LabelMapper.class, nullValueCheckStrategy = ALWAYS)
    @Mapping(source = "rogWithEnum", target = "rogWithEnumOptions", qualifiedBy = LowcodeEnumQualifiers.IdMapper.class, nullValueCheckStrategy = ALWAYS)
    @Mapping(source = "rogWithEnum", target = "rogWithEnumName", qualifiedBy = LowcodeEnumQualifiers.LabelMapper.class, nullValueCheckStrategy = ALWAYS)
    @Mapping(source = "selectWithEnum", target = "selectWithEnumOptions", qualifiedBy = LowcodeEnumQualifiers.IdMapper.class, nullValueCheckStrategy = ALWAYS)
    @Mapping(source = "selectWithEnum", target = "selectWithEnumName", qualifiedBy = LowcodeEnumQualifiers.LabelMapper.class, nullValueCheckStrategy = ALWAYS)
    @Mapping(source = "oneToOneExample", target = "oneToOneResource", qualifiedBy = OneToOneExampleQualifiers.IdMapper.class, nullValueCheckStrategy = ALWAYS)
    @Mapping(source = "oneToOneExample", target = "oneToOneResourceName", qualifiedBy = OneToOneExampleQualifiers.NameMapper.class, nullValueCheckStrategy = ALWAYS)
    FullExampleVo map(FullExample source);

    @InheritInverseConfiguration
    FullExample map(FullExampleVo source);

}
