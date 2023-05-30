package com.jeanne.lowcode.interceptors.query;


import com.jeanne.lowcode.vo.TextSearchVo;

public class TextSearchContext {

    private static ThreadLocal<TextSearchVo> userHolder = new ThreadLocal<>();

    public static void set(TextSearchVo user) {
        userHolder.set(user);
    }

    public static TextSearchVo get() {
        return userHolder.get();
    }

}
