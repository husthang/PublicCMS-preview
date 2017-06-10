package org.publiccms.test.config;

import java.beans.PropertyVetoException;
import java.io.IOException;

import org.publiccms.common.constants.CmsVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import config.spring.ApplicationConfig;
import config.spring.CmsConfig;

/**
 * <h1>CmsRootConfig</h1>
 * <p>
 * Cms跟配置类
 * </p>
 * <p>
 * Spring Config Class
 * </p>
 *
 */
@Import(ApplicationConfig.class)
public class CmsTestConfig {
    static {
        CmsVersion.setInitialized(true);
    }

    @Autowired
    public void init(Environment env) throws IOException, PropertyVetoException {
        CmsConfig.CMS_FILEPATH = System.getProperty("cms.filePath", env.getProperty("cms.filePath"));
    }
}