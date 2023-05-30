package com.jeanne.lowcode.utils;


import com.google.common.base.CaseFormat;
import com.google.common.base.Strings;


public class StringUtils {

    public static String camelToPascal(String camel) {

        if (Strings.isNullOrEmpty(camel)) {
            return "";
        }
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN,camel);
    }

    public static String pascalToCamel(String pascal){
        if (Strings.isNullOrEmpty(pascal)) {
            return "";
        }
       return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL,pascal);
    }
    public static String underscoreToCamel(String pascal){
        if (Strings.isNullOrEmpty(pascal)) {
            return "";
        }
       return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,pascal);
    }

    public static String camelToUnderscore(String camel) {
        if (Strings.isNullOrEmpty(camel)) {
            return "";
        }
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, camel);
    }
}
