package com.thd.bi.controller;

import com.thd.bi.dto.Result;
import com.thd.bi.dto.audit.auditdoc.AuditFindingEntity;
import com.thd.bi.dto.audit.auditdoc.AuditInfoEntity;
import com.thd.bi.dto.audit.auditdoc.AuditVo;
import com.thd.bi.dto.example.ModelBean;
import com.thd.bi.dto.example.SubList;
import com.thd.bi.service.CreatePdfService;
import com.thd.bi.util.RtfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * com.lenovo.dqm.bi.controller.BIController
 *
 * @author: wanglei62
 * @DATE: 2020/2/4 9:53
 **/
@Controller
@RequestMapping("/bi")
public class BIController {
    @Autowired
    private RtfUtils rtfUtils;
    @Autowired
    private CreatePdfService auditDocService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value="/test",method= RequestMethod.GET)
    @ResponseBody
    // url : http://127.0.0.1:8089/bi/test
    public ResponseEntity<Result> test(){
        ModelBean mb = new ModelBean();
        List<SubList> sl = new ArrayList<SubList>();
        for(int i = 0 , j = 200 ; i < j ; i++){
            SubList s = new SubList();
            s.setId(i);
            s.setName("姓名1" + i );
            s.setRemark("备注2" + i);
            sl.add(s);
        }
        mb.setFlag(0);
        mb.setFormName("测试FORM昇威管理有限公司");
        mb.setSubListArray(sl);
        try{
            String pdfPath = rtfUtils.createPdf(mb,"testForm.rtf","auditDOC");
            return ResponseEntity.ok(Result.success(pdfPath));
        }catch(Exception e){
            return ResponseEntity.ok(Result.error(e.getMessage()));
        }

    }

    @RequestMapping(value="/example",method= RequestMethod.GET)
    @ResponseBody
    // url : http://127.0.0.1:8089/bi/example
    public ResponseEntity<String> example(@RequestBody ModelBean mb){
        try{
            String pdfPath = rtfUtils.createPdf(mb,"testForm.rtf","auditDOC");
            return ResponseEntity.ok(pdfPath);
        }catch(Exception e){
            return ResponseEntity.ok("error");
        }
    }


    @RequestMapping(value="/auditDoc",method= RequestMethod.GET)
    @ResponseBody
    // url : http://127.0.0.1:8899/bi/bi/auditDoc
    public void auditDoc( HttpServletResponse response){
        logger.info("auditDoc");

        AuditVo vo = new AuditVo();
        AuditInfoEntity auditInfo = new AuditInfoEntity();
        auditInfo.setActualDateE(new Date());
        auditInfo.setActualDate(new Date());
        auditInfo.setApproveStatus("Good");
        auditInfo.setAuditType("Audit Type");
        auditInfo.setCommodityCode("Commodity");
        auditInfo.setConclusionStatus("OK");
        auditInfo.setRecordNo("2018-01-01-001");
        auditInfo.setConfirmDate(new Date());
        auditInfo.setJqeRating(5.0f);
        auditInfo.setSqeRating(3.0f);
        auditInfo.setPlanDate(new Date());
        auditInfo.setProduct("笔记本电脑");

        AuditFindingEntity finding1 = new AuditFindingEntity();
        finding1.setFinding("FindingA");
        finding1.setConclusion("Conclusion");
        finding1.setFindingStatus("finish");
        finding1.setProcess("Process");

        AuditFindingEntity finding2 = new AuditFindingEntity();
        finding2.setFinding("FindingA");
        finding2.setConclusion("Conclusion");
        finding2.setFindingStatus("finish");
        finding2.setProcess("Process");

        AuditFindingEntity finding3 = new AuditFindingEntity();
        finding3.setFinding("FindingA");
        finding3.setConclusion("Conclusion");
        finding3.setFindingStatus("finish");
        finding3.setProcess("Process");

        List<AuditFindingEntity> findingList = new ArrayList();
        vo.setAuditInfoEntity(auditInfo);
        vo.setAuditFindList(findingList);


        try{
            logger.info("create pdf : auditDoc " + vo.getAuditInfoEntity().getRecordNo());
            String pdfPath = this.auditDocService.createPdf(vo);



//            File f = new File(pdfPath);
//            System.out.println(f.exists());
            FileInputStream in = null;
            OutputStream outp =  response.getOutputStream();
            try {
                outp = response.getOutputStream();
                in = new FileInputStream(pdfPath);
                byte[] b = new byte[1024];
                int i = 0;
                while ((i = in.read(b)) > 0) {
                    outp.write(b, 0, i);
                }
                outp.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    in.close();
                    in = null;
                }
                if (outp != null) {
                    outp.close();
                    outp = null;
                    response.flushBuffer();
                }
            }



            //return ResponseEntity.ok(pdfPath);
        }catch(Exception e){
            e.printStackTrace();
            this.logger.error("create pdf error:");
            this.logger.error("create pdf error [" + vo.getAuditInfoEntity().getRecordNo() + "]");

            //return ResponseEntity.ok(Result.error(e.getMessage()));
        }
    }





}
