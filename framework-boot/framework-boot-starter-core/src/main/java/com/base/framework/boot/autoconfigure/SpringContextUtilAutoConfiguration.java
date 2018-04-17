package com.base.framework.boot.autoconfigure;

import com.base.framework.core.spring.context.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContextUtilAutoConfiguration {

    private static Logger logger = LoggerFactory.getLogger(SpringContextUtilAutoConfiguration.class);

    private static final String COMPONENT_ID = "SpringContext";

    private static final String SPRING_CONTEXT_UTIL = "springContextUtil";


    @Bean
    @ConditionalOnMissingBean
    public SpringContextUtil springContextUtil() {
        SpringContextUtil springContextUtil = new SpringContextUtil();
        LogUtils.instantiateInfo(COMPONENT_ID, SPRING_CONTEXT_UTIL, SpringContextUtil.class, logger);
        AutoInitManage.addInit(SPRING_CONTEXT_UTIL);
        return springContextUtil;
    }

    /**
     * 检查Spring Bean 实例是否冲突
     *
     * @param bean 实例
     */
    @Bean
    @ConditionalOnBean(SpringContextUtil.class)
    public String checkSpringContextUtil(SpringContextUtil bean) {
        if (bean != null && !AutoInitManage.isInit(SPRING_CONTEXT_UTIL)) {
            throw new RuntimeException(LogUtils.checkConflict(SpringContextUtil.class, SpringContextUtilAutoConfiguration.class));
        }
        return null;
    }

}