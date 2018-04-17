package com.base.framework.core.spring.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * SpringContextUtil
 * @author zhouyw
 * @date 2018.04.17
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static Logger logger = LoggerFactory.getLogger(SpringContextUtil.class);
    

    /**
     * 设置spring 上下文
     *
     * @param ctx
     */
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        synchronized (SpringContextUtil.class) {
            logger.debug("setApplicationContext, notifyAll");
            SpringContextUtil.applicationContext = ctx;
            SpringContextUtil.class.notifyAll();
        }
    }

    /**
     * 获取spring 加载的上下文
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        synchronized (SpringContextUtil.class) {
            int count = 3;
            while (applicationContext == null && count > 0) {
                try {
                    logger.debug("getApplicationContext, wait...");
                    SpringContextUtil.class.wait(60000);
                    if (applicationContext == null) {
                        logger.warn("Have been waiting for ApplicationContext to be set for 1 minute", new Exception());
                    }
                } catch (InterruptedException ex) {
                    logger.debug("getApplicationContext, wait interrupted");
                }
                count--;
            }
            return applicationContext;
        }
    }

    /**
     * 根据name获取实例
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 根据name和Class 获取spring 上下文实例
     *
     * @param name
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name, Class<T> type) {
        return (T) getApplicationContext().getBean(name);
    }

    /**
     * 根据实例name 获取Class
     *
     * @param name
     * @return
     */
    public static Class<?> getType(String name) {
        return getApplicationContext().getType(name);
    }

    /**
     * 根据Class获取实例Map
     *
     * @param type
     * @return
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        return getApplicationContext().getBeansOfType(type);
    }

    /**
     * 根据Class获取实例
     *【推荐使用 getBean 】
     * @param type
     * @return
     */
    @Deprecated
    public static <T> T getBeanOfType(Class<T> type) {
        return getBean(type);
    }

    /**
     * 根据Class获取实例
     *
     * @param type
     * @return
     */
    public static <T> T getBean(Class<T> type) {
        Map<String, T> beans = getBeansOfType(type);
        if (beans.size() == 0) {
            throw new NoSuchBeanDefinitionException(type, "Unsatisfied dependency of type [" + type
                    + "]: expected at least 1 matching bean");
        }
        if (beans.size() > 1) {
            throw new NoSuchBeanDefinitionException(type, "expected single matching bean but found " + beans.size()
                    + ": " + beans.keySet());
        }
        return beans.values().iterator().next();
    }
}

