package com.base.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.concurrent.CountDownLatch;

/**
 * ApplicationService
 * @author zhouyw
 * @date 2018.04.18
 */
//@MapperScan(basePackages = "com.base.demo.dao")
@SpringBootApplication(scanBasePackages = {"com.base.demo"})
@EnableAsync
public class ApplicationService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationService.class);


    public static void main(String[] args)throws InterruptedException {
        new SpringApplicationBuilder().sources(ApplicationService.class).web(false).run(args);
        logger.info("启动完成！");
        new CountDownLatch(1).await();
    }
}
