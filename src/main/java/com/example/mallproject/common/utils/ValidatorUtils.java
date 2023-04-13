package com.example.mallproject.common.utils;

public final class ValidatorUtils {
    private ValidatorUtils(){}

    private static final String IS_EMPTY = "%s不能为空";
    private static final String LESS_THAN_ZERO = "%s不能小于0";

    public static void checkNull(Object param, String fieldName) {
        if (param == null) {
            throw new RuntimeException(String.format(IS_EMPTY, fieldName));
        }
    }
}
