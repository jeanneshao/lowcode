package com.jeanne.lowcode.common.utils;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author Jeanne 2023/1/16
 **/
@Component
public class I18NUtils {

    private static MessageSource messageSource;
    private static Locale defaultLocale= Locale.CHINA;

    public I18NUtils(MessageSource messageSource) {
        I18NUtils.messageSource = messageSource;
    }

    /**
     * 获取单个国际化翻译值
     */
    public static String get(String msgKey) {
        try {
            return messageSource.getMessage(msgKey, null, defaultLocale);
        } catch (Exception e) {
            return msgKey;
        }
    }



}