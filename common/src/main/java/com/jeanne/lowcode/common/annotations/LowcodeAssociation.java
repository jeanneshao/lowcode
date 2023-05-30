package com.jeanne.lowcode.common.annotations;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface LowcodeAssociation {
    public AssociationType associationType() default AssociationType.ONE_TO_ONE;

    String associtedResource() ;


    public enum AssociationType {

        ONE_TO_ONE,
        ONE_TO_MANY,
        MANY_TO_MANY,
        MANY_TO_ONE
    }
}
