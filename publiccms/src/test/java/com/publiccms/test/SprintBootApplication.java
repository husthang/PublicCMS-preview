package com.publiccms.test;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.initializer.AdminInitializer;
import config.initializer.ApiInitializer;
import config.initializer.InstallationInitializer;
import config.initializer.ResourceInitializer;
import config.initializer.WebInitializer;
import config.spring.ApplicationConfig;

@Configuration
@Import(ApplicationConfig.class)
public class SprintBootApplication {
    public static File documentRoot;

    public static void main(String[] args) {
        documentRoot = new File("src/main/webapp");
        SpringApplication.run(SprintBootApplication.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setDocumentRoot(documentRoot);
        return factory;
    }

    @Bean
    public ServletContextInitializer webInitializer() {
        return new ServletContextInitializer() {

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                new WebInitializer().onStartup(servletContext);
            }

        };
    }

    @Bean
    public ServletContextInitializer adminInitializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                new AdminInitializer(true).onStartup(servletContext);
            }
        };
    }

    @Bean
    public ServletContextInitializer apiInitializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                new ApiInitializer().onStartup(servletContext);
            }
        };
    }

    @Bean
    public ServletContextInitializer installationInitializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                new InstallationInitializer().onStartup(servletContext);
            }
        };
    }

    @Bean
    public ServletContextInitializer resourceInitializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                new ResourceInitializer().onStartup(servletContext);
            }
        };
    }
}