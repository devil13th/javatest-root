package com.thd.bi.dto.audit.auditdoc;

import lombok.Data;

import java.util.Date;

/**
 * JQE审核信息Entity
 *
 * @author lilong10
 * @date 2019-09-29 12:17:22
 * Copyright 2019 Lenovo GSC Technical Service
 */
@Data
public class AuditInfoEntity extends AuditInfoEntityParent {
	private static final long serialVersionUID = 1L;
	/**
	 * 审核日期结束 - 查询使用
	 */
	private Date actualDateE;
}

