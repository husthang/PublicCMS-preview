package com.publiccms.test.config;

import static config.initializer.InstallationInitializer.CMS_CONFIG_FILE;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.publiccms.common.constants.CmsVersion;
import com.publiccms.common.datasource.CmsDataSource;

/**
 * Created by xinlu.he on 2017/1/11.
 */

@Configuration
@ComponentScan(basePackages = "com.publiccms.test.service")
@MapperScan(basePackages = "com.publiccms.logic.mapper")
@PropertySource({ "classpath:" + CMS_CONFIG_FILE })
public class MybatisConfig {
    @Autowired
    private Environment env;

    /**
     * <p>
     * 数据源
     * </P>
     * <p>
     * data source
     * </p>
     *
     * @return
     * @throws PropertyVetoException
     * @throws IOException
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException, IOException {
        CmsDataSource bean = new CmsDataSource(env.getProperty("cms.database.configFilePath"));
        bean.put("test", CmsDataSource.initDataSource("config/properties/database-test.properties"));
        CmsVersion.setInitialized(false);
        CmsDataSource.initDefautlDataSource();
        return bean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * <p>
     * Mybatis 会话工厂
     * </p>
     * <p>
     * Mybatis Session Factory
     * </p>
     * 
     * @return
     * @throws IOException
     */
    @Bean
    public SqlSessionFactoryBean mybatisSqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(true);
        configuration.setLazyLoadingEnabled(false);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath*:com/publiccms/logic/mapper/**/*Mapper.xml"));
        bean.setConfiguration(configuration);
        return bean;
    }
}
