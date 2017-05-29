package com.hiext.mms.admin.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "f_point_record")
public class FPointRecord implements Serializable {
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
     * 积分类型 0 表示累计 1表示消费
     */
    @Column(name = "point_type")
    private Boolean pointType;

    /**
     * 积分
     */
    private Double point;

    /**
     * 兑换礼品id
     */
    @Column(name = "f_product_id")
    private Long fProductId;

    /**
     * 数量
     */
    private Double count;

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
    private Long datalevel;

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
     * 获取积分类型 0 表示累计 1表示消费
     *
     * @return point_type - 积分类型 0 表示累计 1表示消费
     */
    public Boolean getPointType() {
        return pointType;
    }

    /**
     * 设置积分类型 0 表示累计 1表示消费
     *
     * @param pointType 积分类型 0 表示累计 1表示消费
     */
    public void setPointType(Boolean pointType) {
        this.pointType = pointType;
    }

    /**
     * 获取积分
     *
     * @return point - 积分
     */
    public Double getPoint() {
        return point;
    }

    /**
     * 设置积分
     *
     * @param point 积分
     */
    public void setPoint(Double point) {
        this.point = point;
    }

    /**
     * 获取兑换礼品id
     *
     * @return f_product_id - 兑换礼品id
     */
    public Long getfProductId() {
        return fProductId;
    }

    /**
     * 设置兑换礼品id
     *
     * @param fProductId 兑换礼品id
     */
    public void setfProductId(Long fProductId) {
        this.fProductId = fProductId;
    }

    /**
     * 获取数量
     *
     * @return count - 数量
     */
    public Double getCount() {
        return count;
    }

    /**
     * 设置数量
     *
     * @param count 数量
     */
    public void setCount(Double count) {
        this.count = count;
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
    public Long getDatalevel() {
        return datalevel;
    }

    /**
     * 设置数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     *
     * @param datalevel 数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     */
    public void setDatalevel(Long datalevel) {
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
        sb.append(", pointType=").append(pointType);
        sb.append(", point=").append(point);
        sb.append(", fProductId=").append(fProductId);
        sb.append(", count=").append(count);
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
        FPointRecord other = (FPointRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getfMemberId() == null ? other.getfMemberId() == null : this.getfMemberId().equals(other.getfMemberId()))
            && (this.getPointType() == null ? other.getPointType() == null : this.getPointType().equals(other.getPointType()))
            && (this.getPoint() == null ? other.getPoint() == null : this.getPoint().equals(other.getPoint()))
            && (this.getfProductId() == null ? other.getfProductId() == null : this.getfProductId().equals(other.getfProductId()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getDatalevel() == null ? other.getDatalevel() == null : this.getDatalevel().equals(other.getDatalevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getfMemberId() == null) ? 0 : getfMemberId().hashCode());
        result = prime * result + ((getPointType() == null) ? 0 : getPointType().hashCode());
        result = prime * result + ((getPoint() == null) ? 0 : getPoint().hashCode());
        result = prime * result + ((getfProductId() == null) ? 0 : getfProductId().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getDatalevel() == null) ? 0 : getDatalevel().hashCode());
        return result;
    }
}