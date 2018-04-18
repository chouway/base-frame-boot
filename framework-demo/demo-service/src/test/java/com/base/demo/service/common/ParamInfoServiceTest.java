package com.base.demo.service.common;

import com.alibaba.fastjson.JSON;
import com.base.demo.CommonTest;
import com.base.demo.domain.ParamInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * ParamInfoServiceTest
 * @author zhouyw
 * @date 2018.04.18
 */
public class ParamInfoServiceTest extends CommonTest{

    @Autowired
    private IParamInfoService paramInfoService;

    @Test
    public void getByTypeCode() {
        String type = "type";
        String code = "code_0";
        ParamInfo paramInfo = paramInfoService.getByTypeCode(type, code);
        logger.info("-->paramInfo={}", JSON.toJSONString(paramInfo));
    }

    @Test
    public void getByType() {
    }

    @Test
    public void getSubByTypeCode() {
    }

    @Test
    public void getTree() {
    }
}