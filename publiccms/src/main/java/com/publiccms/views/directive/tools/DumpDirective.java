package com.publiccms.views.directive.tools;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.publiccms.common.base.AbstractTemplateDirective;
import com.sanluan.common.handler.RenderHandler;

/**
 * 
 * DumpDirective 打印变量
 *
 */
@Component
public class DumpDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        handler.dump();
    }

}
