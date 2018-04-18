package com.base.demo;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * CommonTest
 * @author zhouyw
 * @date 2018.04.18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationService.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CommonTest{

    protected Logger logger = LoggerFactory.getLogger(getClass());

}
