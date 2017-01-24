package com.publiccms.logic.component.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import com.publiccms.logic.component.template.TemplateComponent;
import com.publiccms.logic.service.log.LogTaskService;
import com.publiccms.logic.service.sys.SysSiteService;
import com.publiccms.logic.service.sys.SysTaskService;

@Component
public class ScheduledJobDetailFactory extends JobDetailFactoryBean {
    @Autowired
    private SysTaskService sysTaskService;
    @Autowired
    private LogTaskService logTaskService;
    @Autowired
    private SysSiteService siteService;
    @Autowired
    private ScheduledTask scheduledTask;
    @Autowired
    private TemplateComponent templateComponent;

    public ScheduledJobDetailFactory() {
        super();
        setJobClass(ScheduledJob.class);
    }
    
    @Override
    public void afterPropertiesSet(){
        getJobDataMap().put("sysTaskService", sysTaskService);
        getJobDataMap().put("logTaskService", logTaskService);
        getJobDataMap().put("siteService", siteService);
        getJobDataMap().put("scheduledTask", scheduledTask);
        getJobDataMap().put("templateComponent", templateComponent);
        super.afterPropertiesSet();
    }
}
