package com.publiccms.test;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.publiccms.test.config.MybatisConfig;
import com.publiccms.test.service.MybatisService;

/**
 * Created by xinlu.he on 2017/1/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisConfig.class)
public class MybatisTest {
    @Autowired
    MybatisService service;

    @Test
    public void testMybatis() {
        for (Map<String, Object> map : service.select("select * from cms_category")) {
            System.out.println(map);
        }
        service.setDataSourceName("test");
        for (Map<String, Object> map : service.select("select * from cms_category")) {
            System.out.println(map);
        }
        service.resetDataSourceName();
        for (Map<String, Object> map : service.select("select * from cms_category")) {
            System.out.println(map);
        }
    }
}
