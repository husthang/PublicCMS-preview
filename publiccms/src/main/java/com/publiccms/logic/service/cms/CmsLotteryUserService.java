package com.publiccms.logic.service.cms;

// Generated 2016-3-1 17:24:24 by com.sanluan.common.source.SourceGenerator

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.publiccms.entities.cms.CmsLotteryUser;
import com.publiccms.logic.dao.cms.CmsLotteryUserDao;
import com.sanluan.common.base.BaseService;
import com.sanluan.common.handler.PageHandler;

/**
 *
 * CmsLotteryUserService
 * 
 */
@Service
@Transactional
public class CmsLotteryUserService extends BaseService<CmsLotteryUser> {

    /**
     * @param lotteryId
     * @param userId
     * @param winning
     * @param startCreateDate
     * @param endCreateDate
     * @param orderType
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Transactional(readOnly = true)
    public PageHandler getPage(Long lotteryId, Long userId, Boolean winning, Date startCreateDate, Date endCreateDate,
            String orderType, Integer pageIndex, Integer pageSize) {
        return dao.getPage(lotteryId, userId, winning, startCreateDate, endCreateDate, orderType, pageIndex, pageSize);
    }

    @Autowired
    private CmsLotteryUserDao dao;

}