package com.example.mallproject.common.utils;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtil {
    private ThreadLocalUtil() {
    }

    private static final ThreadLocal<Map<String, Object>> THREAD_CONTEXT  = new ThreadLocal<>();

    public static void put(String key, Object object) {
        Map<String, Object> map = THREAD_CONTEXT.get();

        if (map == null) {
            map = new HashMap<>();
            // 把map作为value放进去
            THREAD_CONTEXT.set(map);
        }
        map.put(key, object);
    }

    public static Object get(String key) {
        // 先获取Map
        Map<String, Object> map = THREAD_CONTEXT.get();
        // 从Map中得到USER_INFO
        return map != null ? map.get(key) : null;
    }

    public static void remove(String key) {
        Map<String, Object> map = THREAD_CONTEXT.get();
        map.remove(key);
    }

    public static void clear() {
        THREAD_CONTEXT.remove();
    }
}
