package com.sanluan.common.source;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * Created by xinlu on 2017/1/8.
 */
public class MybatisGenerator {
    @Test
    public void testMain() throws Throwable {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        InputStream stream = new FileInputStream("src/test/resources/mybatis/generatorConfig.xml");
        Configuration config = cp.parseConfiguration(stream);
        DefaultShellCallback shellCallback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
        myBatisGenerator.generate(null);
    }
}
