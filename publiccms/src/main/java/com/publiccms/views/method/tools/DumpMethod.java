package com.publiccms.views.method.tools;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sanluan.common.api.Json;
import com.sanluan.common.base.BaseMethod;

import freemarker.template.TemplateModelException;

@Component
public class DumpMethod extends BaseMethod implements Json {

    /*
     * (non-Javadoc)
     * 
     * @see freemarker.template.TemplateMethodModelEx#exec(java.util.List)
     */
    @Override
    public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
        if (null != arguments) {
            try {
                if (1 == arguments.size()) {
                    return objectMapper.writeValueAsString(arguments.get(0));
                } else {
                    return objectMapper.writeValueAsString(arguments);
                }
            } catch (JsonProcessingException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean needAppToken() {
        return false;
    }

    @Override
    public int minParamtersNumber() {
        return 1;
    }
}
