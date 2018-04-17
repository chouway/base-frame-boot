package com.base.framework.boot.autoconfigure;

import java.util.HashMap;
import java.util.Map;

/**
 * 仅限  AutoConfiguration 使用
 * 自动装配管理类，用于检查相同类型的实例，是否重复初始化
 *
 */
public class AutoInitManage {

    private static final Map<String, Boolean> map = new HashMap<>();

    /**
     * 添加实例Id，记录实例已经初始化
     *
     * @param beanName 实例名
     */
    public static void addInit(String beanName) {
        map.put(beanName, true);
    }

    /**
     * 判断实例是否初始化
     *
     * @param beanName 实例名
     */
    static boolean isInit(String beanName) {
        if (!map.containsKey(beanName)) {
            return false;
        }
        return map.get(beanName);
    }
}
