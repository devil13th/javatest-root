package com.thd.bi.dto.audit.auditdoc;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * com.lenovo.dqm.audit.vo.AuditVo
 *
 * @author: wanglei62
 * @DATE: 2019/10/17 17:17
 **/
@Data
public class AuditVo {
    private AuditInfoEntity auditInfoEntity;
    private List<AuditFindingEntity> auditFindList = new ArrayList<AuditFindingEntity>();


}
