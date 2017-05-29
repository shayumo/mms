package com.hiext.mms.admin.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "f_count_record")
public class FCountRecord implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 会员id
     */
    @Column(name = "f_member_id")
    private Long fMemberId;

    /**
     * 金额类型 0 表示充值 1表示消费
     */
    @Column(name = "count_type")
    private Short countType;

    /**
     * 金额
     */
    private Double sum;

    /**
     * 付款方式 付款方式 0 表示默认为余额消费 1表示 现金消费 2同时使用余额与现金
     */
    @Column(name = "pay_type")
    private Short payType;

    /**
     * 现金
     */
    @Column(name = "pay_monery")
    private Double payMonery;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人编号
     */
    @Column(name = "CreatorId")
    private Long creatorid;

    /**
     * 创建人姓名
     */
    @Column(name = "CreatorName")
    private String creatorname;

    /**
     * 创建日期
     */
    @Column(name = "CreateDate")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    private Date createdate;

    /**
     * 数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     */
    @Column(name = "DataLevel")
    private int datalevel;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return Id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取会员id
     *
     * @return f_member_id - 会员id
     */
    public Long getfMemberId() {
        return fMemberId;
    }

    /**
     * 设置会员id
     *
     * @param fMemberId 会员id
     */
    public void setfMemberId(Long fMemberId) {
        this.fMemberId = fMemberId;
    }

    /**
     * 获取金额类型 0 表示充值 1表示消费
     *
     * @return count_type - 金额类型 0 表示充值 1表示消费
     */
    public Short getCountType() {
        return countType;
    }

    /**
     * 设置金额类型 0 表示充值 1表示消费
     *
     * @param countType 金额类型 0 表示充值 1表示消费
     */
    public void setCountType(Short countType) {
        this.countType = countType;
    }

    /**
     * 获取金额
     *
     * @return sum - 金额
     */
    public Double getSum() {
        return sum;
    }

    /**
     * 设置金额
     *
     * @param sum 金额
     */
    public void setSum(Double sum) {
        this.sum = sum;
    }

    /**
     * 获取付款方式 付款方式 0 表示默认为余额消费 1表示 现金消费 2同时使用余额与现金
     *
     * @return pay_type - 付款方式 付款方式 0 表示默认为余额消费 1表示 现金消费 2同时使用余额与现金
     */
    public Short getPayType() {
        return payType;
    }

    /**
     * 设置付款方式 付款方式 0 表示默认为余额消费 1表示 现金消费 2同时使用余额与现金
     *
     * @param payType 付款方式 付款方式 0 表示默认为余额消费 1表示 现金消费 2同时使用余额与现金
     */
    public void setPayType(Short payType) {
        this.payType = payType;
    }

    /**
     * 获取现金
     *
     * @return pay_monery - 现金
     */
    public Double getPayMonery() {
        return payMonery;
    }

    /**
     * 设置现金
     *
     * @param payMonery 现金
     */
    public void setPayMonery(Double payMonery) {
        this.payMonery = payMonery;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建人编号
     *
     * @return CreatorId - 创建人编号
     */
    public Long getCreatorid() {
        return creatorid;
    }

    /**
     * 设置创建人编号
     *
     * @param creatorid 创建人编号
     */
    public void setCreatorid(Long creatorid) {
        this.creatorid = creatorid;
    }

    /**
     * 获取创建人姓名
     *
     * @return CreatorName - 创建人姓名
     */
    public String getCreatorname() {
        return creatorname;
    }

    /**
     * 设置创建人姓名
     *
     * @param creatorname 创建人姓名
     */
    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname;
    }

    /**
     * 获取创建日期
     *
     * @return CreateDate - 创建日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建日期
     *
     * @param createdate 创建日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     *
     * @return DataLevel - 数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     */
    public int getDatalevel() {
        return datalevel;
    }

    /**
     * 设置数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     *
     * @param datalevel 数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     */
    public void setDatalevel(int datalevel) {
        this.datalevel = datalevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fMemberId=").append(fMemberId);
        sb.append(", countType=").append(countType);
        sb.append(", sum=").append(sum);
        sb.append(", payType=").append(payType);
        sb.append(", payMonery=").append(payMonery);
        sb.append(", remark=").append(remark);
        sb.append(", creatorid=").append(creatorid);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", createdate=").append(createdate);
        sb.append(", datalevel=").append(datalevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FCountRecord other = (FCountRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getfMemberId() == null ? other.getfMemberId() == null : this.getfMemberId().equals(other.getfMemberId()))
            && (this.getCountType() == null ? other.getCountType() == null : this.getCountType().equals(other.getCountType()))
            && (this.getSum() == null ? other.getSum() == null : this.getSum().equals(other.getSum()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayMonery() == null ? other.getPayMonery() == null : this.getPayMonery().equals(other.getPayMonery()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getfMemberId() == null) ? 0 : getfMemberId().hashCode());
        result = prime * result + ((getCountType() == null) ? 0 : getCountType().hashCode());
        result = prime * result + ((getSum() == null) ? 0 : getSum().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayMonery() == null) ? 0 : getPayMonery().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }
}