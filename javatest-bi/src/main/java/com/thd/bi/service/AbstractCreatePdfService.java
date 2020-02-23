package com.thd.bi.service;

import com.thd.bi.util.RtfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * com.lenovo.dqm.bi.service.AbstractCreatePdfService
 *
 * @author: wanglei62
 * @DATE: 2020/2/7 17:03
 **/
@Component
public abstract class AbstractCreatePdfService implements CreatePdfService {
    // 模板名称 , 在子类中设置值
    private String templateName;

    @Autowired
    private RtfUtils rtfUtils;
    public String createPdf(Object vo) {
        return this.process(vo);
    }

    /**
     * 创建pdf过程
     * @param vo
     * @return
     */
    public abstract String process(Object vo);


    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public RtfUtils getRtfUtils() {
        return rtfUtils;
    }

    public void setRtfUtils(RtfUtils rtfUtils) {
        this.rtfUtils = rtfUtils;
    }
}
