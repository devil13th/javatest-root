package com.thd.bi.dto.audit.auditdoc;


import lombok.Data;

import java.util.Date;

/**
 * Finding问题信息EntityParent
 *
 * @author lilong10
 * @date 2019-10-17 14:28:20
 * Copyright 2019 Lenovo GSC Technical Service
 */
@Data
public class AuditFindingEntityParent{
	private static final long serialVersionUID = 1L;

	/**
	 * 审核工作id
	 */
	private Long auditId;
	/**
	 * finding
	 */
	private String finding;
	/**
	 * target_date
	 */
	private Date targetDate;
	/**
	 * 问题状态 close 关闭   cancel 取消
	 */
	private String findingStatus;
	/**
	 * 备注
	 */
	private String conclusion;
	/**
	 * 工作内容
	 */
	private String jqeWorkingItem;
	/**
	 * 阶段
	 */
	private String process;
	/**
	 * 实际落实日期
	 */
	private Date actualActionDate;
	/**
	 * 处理内容
	 */
	private String dealAction;
	/**
	 * 通用开始日期
	 */
	private Date startDate;
	/**
	 * 通用结束日期
	 */
	private Date endDate;

}

