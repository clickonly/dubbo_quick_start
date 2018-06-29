package org.dubbo.api.dao;

import org.dubbo.pojo.bean.wx.WxMessageTemplate;

/**
 * Created by fanglei on 2018/1/16.
 */
public interface WxMessageTemplateDao {

    /**
     * 获取模板消息
     * @param wxMessageTemplate
     * @return
     */
    WxMessageTemplate getWxMessageTemplate (WxMessageTemplate wxMessageTemplate);

    /**
     * 获取指定的模板消息
     * @param id
     * @return
     */
    WxMessageTemplate getWxMessageTemplateById(Long id);

}
