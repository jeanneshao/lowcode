package com.jeanne.lowcode.mapperstruct.qualifiers;

import com.jeanne.lowcode.entity.LowcodeEnum;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Jeanne 2023/5/22
 **/
public class LowcodeEnumQualifiers {
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface LabelMapper {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface ValueMapper {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface IdMapper {
    }


    @LabelMapper
    public String getEnumLabel(LowcodeEnum in) {
        return in.getLabel();
    }

    @LabelMapper
    public LowcodeEnum getEnumLabel(String in) {
        return null;
    }


    @ValueMapper
    public String getEnumValue(LowcodeEnum in) {
        return in.getValue();
    }

    @IdMapper
    public Long getEnumId(LowcodeEnum in) {
        return in.getId();
    }

    @IdMapper
    public LowcodeEnum getEnumId(Long in) {
        LowcodeEnum lowcodeEnum = new LowcodeEnum();
        lowcodeEnum.setId(in);
        return lowcodeEnum;
    }
}
