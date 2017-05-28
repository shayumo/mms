package com.hiext.mms.admin.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "f_member")
public class FMember implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 会员姓名
     */
    private String name;

    /**
     * 性别 0未知 1男 2女
     */
    @Column(name = "Sex")
    private Integer sex;

    /**
     * 电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 生日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    /**
     * 会员卡号
     */
    @Column(name = "card_NO")
    private String cardNo;

    /**
     * 有效期
     */
    @Column(name = "card_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cardDate;

    /**
     * 会员当前余额
     */
    @Column(name = "card_monery")
    private Double cardMonery;

    /**
     * 会员等级
     */
    @Column(name = "f_vip_id")
    private Long fVipId;

    /**
     * 会员级别
     */
    @Column(name = "f_vip_name")
    private String fVipName;

    /**
     * 会员卡积分
     */
    @Column(name = "f_point_sum")
    private Double fPointSum;

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
    @DateTimeFormat(pattern="yyyy-MM-dd")
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
     * 获取会员姓名
     *
     * @return name - 会员姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置会员姓名
     *
     * @param name 会员姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别 0未知 1男 2女
     *
     * @return Sex - 性别 0未知 1男 2女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别 0未知 1男 2女
     *
     * @param sex 性别 0未知 1男 2女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取电话
     *
     * @return Tel - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取会员卡号
     *
     * @return card_NO - 会员卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置会员卡号
     *
     * @param cardNo 会员卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * 获取有效期
     *
     * @return card_date - 有效期
     */
    public Date getCardDate() {
        return cardDate;
    }

    /**
     * 设置有效期
     *
     * @param cardDate 有效期
     */
    public void setCardDate(Date cardDate) {
        this.cardDate = cardDate;
    }

    /**
     * 获取会员当前余额
     *
     * @return card_monery - 会员当前余额
     */
    public Double getCardMonery() {
        return cardMonery;
    }

    /**
     * 设置会员当前余额
     *
     * @param cardMonery 会员当前余额
     */
    public void setCardMonery(Double cardMonery) {
        this.cardMonery = cardMonery;
    }

    /**
     * 获取会员等级
     *
     * @return f_vip_id - 会员等级
     */
    public Long getfVipId() {
        return fVipId;
    }

    /**
     * 设置会员等级
     *
     * @param fVipId 会员等级
     */
    public void setfVipId(Long fVipId) {
        this.fVipId = fVipId;
    }

    /**
     * 获取会员级别
     *
     * @return f_vip_name - 会员级别
     */
    public String getfVipName() {
        return fVipName;
    }

    /**
     * 设置会员级别
     *
     * @param fVipName 会员级别
     */
    public void setfVipName(String fVipName) {
        this.fVipName = fVipName;
    }

    /**
     * 获取会员卡积分
     *
     * @return f_point_sum - 会员卡积分
     */
    public Double getfPointSum() {
        return fPointSum;
    }

    /**
     * 设置会员卡积分
     *
     * @param fPointSum 会员卡积分
     */
    public void setfPointSum(Double fPointSum) {
        this.fPointSum = fPointSum;
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
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", tel=").append(tel);
        sb.append(", birthday=").append(birthday);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", cardDate=").append(cardDate);
        sb.append(", cardMonery=").append(cardMonery);
        sb.append(", fVipId=").append(fVipId);
        sb.append(", fVipName=").append(fVipName);
        sb.append(", fPointSum=").append(fPointSum);
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
        FMember other = (FMember) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getCardDate() == null ? other.getCardDate() == null : this.getCardDate().equals(other.getCardDate()))
            && (this.getCardMonery() == null ? other.getCardMonery() == null : this.getCardMonery().equals(other.getCardMonery()))
            && (this.getfVipId() == null ? other.getfVipId() == null : this.getfVipId().equals(other.getfVipId()))
            && (this.getfVipName() == null ? other.getfVipName() == null : this.getfVipName().equals(other.getfVipName()))
            && (this.getfPointSum() == null ? other.getfPointSum() == null : this.getfPointSum().equals(other.getfPointSum()))
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getCardDate() == null) ? 0 : getCardDate().hashCode());
        result = prime * result + ((getCardMonery() == null) ? 0 : getCardMonery().hashCode());
        result = prime * result + ((getfVipId() == null) ? 0 : getfVipId().hashCode());
        result = prime * result + ((getfVipName() == null) ? 0 : getfVipName().hashCode());
        result = prime * result + ((getfPointSum() == null) ? 0 : getfPointSum().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }
}