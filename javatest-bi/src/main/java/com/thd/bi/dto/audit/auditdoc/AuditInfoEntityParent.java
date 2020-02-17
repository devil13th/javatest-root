package com.thd.bi.dto.audit.auditdoc;


import lombok.Data;

import java.util.Date;

/**
 * JQE审核信息EntityParent
 *
 * @author lilong10
 * @date 2019-09-29 12:17:22
 * Copyright 2019 Lenovo GSC Technical Service
 */
@Data
public class AuditInfoEntityParent {
	private static final long serialVersionUID = 1L;
	/**
	 * 审核分类,字典为 Annual Audit, Certify Audit, Quality Issue Audit, NPI Stage Audit
	 */
	private String auditType;
	/**
	 * Yes 或者 No，用来标识这个Audit记录是否是二次审核
	 */
	private String reAudit;
	/**
	 * 如果是第二次审核才会有值,是第一次审核的no
	 */
	private String relatedRecordNo;
	/**
	 * 审核编号 ，系统自动生成，以标题首字母加8位当天日期（YYYYMMDD）开始，最后三位排序，比如001，002…，Annual Audit用A开头，Certification Audit用C开头，Quality Issue Audit用Q开头，NPI Stage Audit用N开头）
	 */
	private String recordNo;
	/**
	 * 部件代码
	 */
	private String commodityCode;
	/**
	 * 产品，如何审核类型是Quality Issue和NPI Stage Audit次字段是必填
	 */
	private String product;
	/**
	 * 供应商名称
	 */
	private String vendorName;
	/**
	 * 供应商code
	 */
	private String vendorCode;
	/**
	 * vendor_site
	 */
	private String vendorSite;
	/**
	 * 计划审核日期
	 */
	private Date planDate;
	/**
	 * 计划审核日期
	 */
	private Date planDateEnd;
	/**
	 * 联合质量工程师的id
	 */
	private String jqeId;
	/**
	 * jqe姓名
	 */
	private String jqeName;
	/**
	 * 供应商质量工程师id
	 */
	private String sqeId;
	/**
	 * sqe姓名
	 */
	private String sqeName;
	/**
	 * 供应商质量工程师直线上级id
	 */
	private String sqeLineManagerId;
	/**
	 * sqe直线经理名称
	 */
	private String sqeLineManagerName;
	/**
	 * 审核目的
	 */
	private String reasonForAudit;
	/**
	 * jqe确认时间
	 */
	private Date confirmDate;
	/**
	 * jqe确认时间
	 */
	private Date confirmDateEnd;
	/**
	 * 实际审核日期
	 */
	private Date actualDate;
	/**
	 * 实际审核日期
	 */
	private Date actualDateEnd;
	/**
	 * 联想内部参加人
	 */
	private String lenovoAttendance;
	/**
	 * 供应商参加人
	 */
	private String supplierAttendees;
	/**
	 * 结论，值为Approve 通过，Conditional Approve 有条件通过，Reject 不通过
	 */
	private String conclusionStatus;
	/**
	 * 备注
	 */
	private String comments;
	/**
	 * 审批结果，值为Acceptable 通过, Reject 不通过
	 */
	private String approveStatus;
	/**
	 * 审核结论
	 */
	private String auditConclusion;
	/**
	 * 不通过原因
	 */
	private String rejectReason;
	/**
	 * qsa 打分
	 */
	private String qsaRating;
	/**
	 * jqe得分
	 */
	private Float jqeRating;
	/**
	 * sqe_rating
	 */
	private Float sqeRating;
	/**
	 * jqe_comments
	 */
	private String jqeComments;
	/**
	 * sqe_comments
	 */
	private String sqeComments;
	/**
	 * 关闭工作原因
	 */
	private String closeReason;
	/**
	 * 是否因为取消工作而关闭工作的  Y:是  N:不是
	 */
	private String isCancel;
	/**
	 * 通用开始日期
	 */
	private Date startDate;
	/**
	 * 通用结束日期
	 */
	private Date endDate;

}

