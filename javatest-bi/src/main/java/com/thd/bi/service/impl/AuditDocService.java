package com.thd.bi.service.impl;

import com.thd.bi.service.AbstractCreatePdfService;
import org.springframework.stereotype.Component;

/**
 * com.lenovo.dqm.bi.service.impl.AuditDocService
 *
 * @author: wanglei62
 * @DATE: 2020/2/7 17:10
 **/
@Component
public class AuditDocService extends AbstractCreatePdfService {
    public AuditDocService(){
        this.setTemplateName("auditDoc.rtf");
    }
    @Override
    public String process(Object vo) {
        String pdfPath = this.getRtfUtils().createPdf(vo,this.getTemplateName(), "auditDOC");
        return pdfPath;
    }
}
