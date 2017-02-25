package config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import com.publiccms.common.servlet.MultiSiteWebHttpRequestHandler;
import com.publiccms.logic.component.site.SiteComponent;

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
public class CmsRootConfig {

    /**
     * <p>
     * 资源处理器
     * </p>
     * <p>
     * DefaultServletHttpRequestHandler
     * </p>
     * 
     * @return
     */
    @Bean
    public HttpRequestHandler defaultServlet() {
        DefaultServletHttpRequestHandler bean = new DefaultServletHttpRequestHandler();
        return bean;
    }

    /**
     * <p>
     * 站点静态页面处理器
     * </p>
     * <p>
     * DefaultServletHttpRequestHandler
     * </p>
     * 
     * @return
     */
    @Bean
    public HttpRequestHandler webfileServlet(SiteComponent siteComponent) {
        MultiSiteWebHttpRequestHandler bean = new MultiSiteWebHttpRequestHandler(siteComponent);
        return bean;
    }
}