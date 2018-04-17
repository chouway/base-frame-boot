package com.base.framework.boot.autoconfigure;

import org.slf4j.Logger;
import org.springframework.util.ClassUtils;

import java.beans.Introspector;

/**
 * 仅限  AutoConfiguration 使用

 */
public class LogUtils {

    /**
     * 打印实例化信息
     *
     * @param componentId 组件ID
     * @param config      配置信息字符
     * @param logger      日志输出对象
     */
    protected static void configInfo(String componentId, String config, Logger logger) {
        logger.info(componentId + " 的配置 " + config);
    }

    /**
     * 打印实例化信息
     *
     * @param componentId 组件ID
     * @param beanName    实例名称
     * @param clazz       类
     * @param logger      日志输出对象
     */
    protected static void instantiateInfo(String componentId, String beanName, Class clazz, Logger logger) {
        logger.info(componentId + " 实例化完成 (BeanName=" + beanName + ",Class=" + clazz.getName() + ").");
    }

    /**
     * 打印实例化信息(BeanName首字母小写)
     *
     * @param componentId 组件ID
     * @param clazz       类
     * @param logger      日志输出对象
     */
    protected static void instantiateInfo(String componentId, Class clazz, Logger logger) {
        //实体名称
        String className = ClassUtils.getShortName(clazz);
        String beanName = Introspector.decapitalize(className);
        instantiateInfo(componentId, beanName, clazz, logger);
    }

    /**
     * 实例化失败信息
     *
     * @param componentId 组件ID
     * @param beanName    实例名称
     * @param clazz       类
     * @param exception   异常对象
     */
    static String instantiateFailureMsg(String componentId, String beanName, Class clazz, Exception exception, Logger logger) {
        String log = componentId + " 实例化失败 (BeanName=" + beanName + ",Class=" + clazz.getName() + ")," + exception.getMessage();
        logger.error(log);
        return log;
    }

    /**
     * 打印添加到 web 的拦截链信息
     *
     * @param componentId 组件ID
     * @param beanName    实例名称
     * @param logger      日志输出对象
     */
    static void addFilterInfo(String componentId, String beanName, Logger logger) {
        logger.info(componentId + " " + beanName + " 添加到 web 的拦截链.");
    }

    /**
     * 只允许 web 工程使用
     *
     * @param projectName 工程名
     * @return 日志字符
     */
    static String onlyAllowedWeb(String projectName) {
        return projectName + " 只允许 web 工程使用.";
    }

    /**
     * 只允许 service 工程使用
     *
     * @param projectName 工程名
     * @return 日志字符
     */
    static String onlyAllowedService(String projectName) {
        return projectName + " 只允许 service 工程使用.";
    }

    /**
     * 检查冲突
     *
     * @param targetClass            检查冲突的目录类
     * @param autoConfigurationClass 自动装配类
     * @return 日志字符
     */
    static String checkConflict(Class targetClass, Class autoConfigurationClass) {
        return targetClass.getName() + " 的实例已经存在，请排除实例 或 排除自动装配@SpringBootApplication(exclude = {" + autoConfigurationClass.getName() + ".class})";
    }
}
