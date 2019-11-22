package com.bowensun.film.web;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
//import javax.validation.constraints.NotNull;

public class InvMidReply implements Serializable, Cloneable{

    private static final long serialVersionUID = 2623819430129169702L;

    private String appNo;//发票申请单号

    private String invoiceId;//流水号，同一税号全局唯一（永远不能重复）

    private String invoiceCode;//发票代码

    private String invoiceNum;//发票号码

    @JsonFormat(pattern="yyyyMMdd", timezone="GMT+8")
    private Date invoiceYmd;//开票日期(YYYYMMDD)

    private String invoiceTime;

    private String invoiceType;//发票类型

    private String checkCode;//校验码(增值税普票有效，增值税专票固定为空)

    private BigDecimal totalAmount;//合计金额

    private BigDecimal totalTax;//合计税额

    private BigDecimal totalTaxAmount;//价税合计

    private String remak;//备注

    private Date insertTime;//写入时间

    private String syncFlag;//同步标志位(0=未同步，发票系统写入;1=已同步，MRO系统更新)

    private String lyxybs;//来源系统标志

    private String transId;

    private String ztbz; // 流水单状态标志

    private Long invMidReply;

    private String id; //流水单ID

    private String hbid; //合并流水单ID

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getInvoiceYmd() {
        return invoiceYmd;
    }

    public void setInvoiceYmd(Date invoiceYmd) {
        this.invoiceYmd = invoiceYmd;
    }

    public String getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(String invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        if ("004".equals (invoiceType)){
            this.invoiceType = "专票";
        }else if ("007".equals (invoiceType)){
            this.invoiceType = "普票";
        }else if ("026".equals (invoiceType)){
            this.invoiceType = "电票";
        }else{
            this.invoiceType = invoiceType;
        }

    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public String getRemak() {
        return remak;
    }

    public void setRemak(String remak) {
        this.remak = remak;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(String syncFlag) {
        this.syncFlag = syncFlag;
    }

    public String getLyxybs() {
        return lyxybs;
    }

    public void setLyxybs(String lyxybs) {
        this.lyxybs = lyxybs;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public Long getInvMidReply() {
        return invMidReply;
    }

    public void setInvMidReply(Long invMidReply) {
        this.invMidReply = invMidReply;
    }

    public String getZtbz() {
        return ztbz;
    }

    public void setZtbz(String ztbz) {
        this.ztbz = ztbz;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHbid() {
        return hbid;
    }

    public void setHbid(String hbid) {
        this.hbid = hbid;
    }
}
