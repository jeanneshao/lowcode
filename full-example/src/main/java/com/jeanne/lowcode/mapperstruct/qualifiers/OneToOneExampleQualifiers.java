package com.jeanne.lowcode.mapperstruct.qualifiers;

import com.jeanne.lowcode.dto.OneToOneExampleDto;
import com.jeanne.lowcode.entity.LowcodeEnum;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Jeanne 2023/5/22
 **/
public class OneToOneExampleQualifiers {
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface NameMapper {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface IdMapper {
    }



    @NameMapper
    public String getOneToOneName(OneToOneExampleDto in) {
        return in.getName();
    }

    @IdMapper
    public Long getOneToOneId(OneToOneExampleDto in) {
        return in.getId();
    } @IdMapper
    public OneToOneExampleDto getOneToOneId(Long in) {
        OneToOneExampleDto oneToOneExampleDto = new OneToOneExampleDto();
        oneToOneExampleDto.setId(in);
        return oneToOneExampleDto;
    }
}
