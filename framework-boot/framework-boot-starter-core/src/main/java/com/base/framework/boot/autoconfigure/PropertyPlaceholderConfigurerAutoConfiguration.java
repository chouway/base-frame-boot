package com.base.framework.boot.autoconfigure;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@AutoConfigureBefore(PropertyPlaceholderAutoConfiguration.class)
public class PropertyPlaceholderConfigurerAutoConfiguration implements EnvironmentAware {

    private static Logger logger = LoggerFactory.getLogger(PropertyPlaceholderConfigurerAutoConfiguration.class);

    private static final String COMPONENT_ID = "SpringProperty";

    private static final String IGNORE_RESOURCE_NOT_FOUND = "framework.properties.ignore-resource-not-found";

    private static final String LOCATIONS = "framework.properties.locations";

    private static final String PROPERTY_PLACEHOLDER_CONFIGURER = "propertyPlaceholderConfigurer";

    private Object[] locations;

    private boolean ignoreResourceNotFound = true;

    @Override
    public void setEnvironment(Environment environment) {
        ignoreResourceNotFound = Boolean.parseBoolean(environment.getProperty(IGNORE_RESOURCE_NOT_FOUND, String.valueOf(true)));
        //
        setLocations(environment);
    }

    /**
     * <pre>
     *      <bean id="propertyPlaceholderConfigurer" class="com.base.framework.spring.beans.factory.config.PropertyPlaceholderConfigurer">
     *          <property name="ignoreResourceNotFound" value="true"/>
     *          <property name="locations">
     *              <list>
     *                  <value>classpath:properties/*.properties</value>
     *          </list>
     *          </property>
     *      </bean>
     * </pre>
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setIgnoreResourceNotFound(ignoreResourceNotFound);
        propertyPlaceholderConfigurer.setLocations(resolveLocations());
        LogUtils.instantiateInfo(COMPONENT_ID, PROPERTY_PLACEHOLDER_CONFIGURER, PropertyPlaceholderConfigurer.class, logger);
        AutoInitManage.addInit(PROPERTY_PLACEHOLDER_CONFIGURER);
        return propertyPlaceholderConfigurer;
    }

    /**
     * 检查Spring Bean 实例是否冲突
     *
     * @param bean 实例
     */
    @Bean
    @ConditionalOnBean(PropertyPlaceholderConfigurer.class)
    public String checkPropertyPlaceholderConfigurer(PropertyPlaceholderConfigurer bean) {
        if (bean != null && !AutoInitManage.isInit(PROPERTY_PLACEHOLDER_CONFIGURER)) {
            throw new RuntimeException(LogUtils.checkConflict(PropertyPlaceholderConfigurer.class, PropertyPlaceholderConfigurerAutoConfiguration.class));
        }
        return null;
    }

    /**
     * 配置多个时，通过environment会是数组
     * framework.properties.locations[0]=xxx1.properties
     * framework.properties.locations[1]=xxx2.properties
     * framework.properties.locations[2]=xxx3.properties
     *
     * @param environment
     */
    private void setLocations(Environment environment) {
        List<Object> locationsList = new ArrayList<>();
        int count = 0;
        //默认在 classpath:/META-INF/properties/ 目录下的所以 properties 文件
        String location = environment.getProperty(LOCATIONS + "[" + count + "]", "classpath:/META-INF/properties/*.properties");
        while (!StringUtils.isEmpty(location)) {
            locationsList.add(location);
            count++;
            location = environment.getProperty(LOCATIONS + "[" + count + "]");
        }
        locations = locationsList.toArray();
    }

    private Resource[] resolveLocations() {
        List<Resource> resources = new ArrayList<>();
        if (this.locations != null) {
            for (Object location : this.locations) {
                Resource[] resLocation;
                try {
                    resLocation = new PathMatchingResourcePatternResolver().getResources(location.toString());
                    resources.addAll(Arrays.asList(resLocation));
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        Resource[] resLocations = new Resource[resources.size()];
        resLocations = resources.toArray(resLocations);
        return resLocations;
    }

}