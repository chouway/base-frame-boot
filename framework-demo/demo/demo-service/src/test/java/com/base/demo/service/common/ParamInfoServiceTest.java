package com.base.demo.service.common;

import com.alibaba.fastjson.JSON;
import com.base.demo.CommonTest;
import com.base.demo.domain.ParamInfo;
import com.base.demo.service.common.vo.ParamInfoCond;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        String type = "type";
        String code = "code_0";
        List<ParamInfo> tree = paramInfoService.getTree(type, code);
        logger.info("-->tree={}", JSON.toJSONString(tree));
    }

    @Test
    @Rollback(false)//测试下：允许事务直接提交数据库
    public void save() {
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setCode("code_t");
        paramInfo.setName("name_t");
        paramInfo.setType("type_t");
        paramInfo.setRemark("remark_t");
        paramInfo.setParentId("parentId_t");
        ParamInfo newAdd = paramInfoService.save(paramInfo);
        logger.info("-->newAdd.getId()={}", newAdd.getId());
        logger.info("-->newAdd={}", JSON.toJSONString(newAdd));
    }

    @Test
    public void remove() {//测试下 自动回滚事务
        String id = "b";
        int remove = paramInfoService.remove(id);
        logger.info("-->remove={}", remove);
        
    }

    @Test
    public void getPage() {
        ParamInfoCond cond = new ParamInfoCond();
        cond.setType("type");
        PagedListHolder<ParamInfo> page = new PagedListHolder<>();
        page.setPage(0);
        page.setPageSize(1);
        PagedListHolder<ParamInfo> pageDb = paramInfoService.getPage(cond, page);
        logger.info("-->pageDb={}", JSON.toJSONString(pageDb));
    }
}