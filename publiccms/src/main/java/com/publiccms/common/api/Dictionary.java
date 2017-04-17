package com.publiccms.common.api;

import java.util.List;

import com.publiccms.views.pojo.DictionaryData;

/**
 *
 * Dictionary
 * 
 */
public interface Dictionary {
    
    /**
     * @return
     */
    public String getName();

    /**
     * @return
     */
    public String getCode();

    /**
     * @return
     */
    public List<DictionaryData> getDataList();
}