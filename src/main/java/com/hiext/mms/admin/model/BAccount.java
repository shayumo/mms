package com.hiext.mms.admin.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "b_account")
public class BAccount implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 数据级别  -1代表无效
     */
    @Column(name = "DATALEVEL")
    private Byte datalevel;

    /**
     * 0有效，1无效
     */
    @Column(name = "STATUS")
    private Byte status;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    /**
     * 男0 女1
     */
    @Column(name = "SEX")
    private Byte sex;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ZIP")
    private String zip;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "CARD_ID")
    private String cardId;

    @Column(name = "IMG")
    private String img;

    @Column(name = "QQ")
    private String qq;

    @Column(name = "WEIXIN")
    private String weixin;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "DYNAMIC_FILED")
    private String dynamicFiled;

    @Column(name = "FILED1")
    private String filed1;

    @Column(name = "FILED2")
    private String filed2;

    @Column(name = "FILED3")
    private String filed3;

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取数据级别  -1代表无效
     *
     * @return DATALEVEL - 数据级别  -1代表无效
     */
    public Byte getDatalevel() {
        return datalevel;
    }

    /**
     * 设置数据级别  -1代表无效
     *
     * @param datalevel 数据级别  -1代表无效
     */
    public void setDatalevel(Byte datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * 获取0有效，1无效
     *
     * @return STATUS - 0有效，1无效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置0有效，1无效
     *
     * @param status 0有效，1无效
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @return ACCOUNT
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取男0 女1
     *
     * @return SEX - 男0 女1
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置男0 女1
     *
     * @param sex 男0 女1
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * @return TYPE
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return TEL
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return MOBILE
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return ADDRESS
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return ZIP
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return BIRTHDAY
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return CARD_ID
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * @param cardId
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * @return IMG
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return WEIXIN
     */
    public String getWeixin() {
        return weixin;
    }

    /**
     * @param weixin
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    /**
     * @return CREATEDATE
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return DYNAMIC_FILED
     */
    public String getDynamicFiled() {
        return dynamicFiled;
    }

    /**
     * @param dynamicFiled
     */
    public void setDynamicFiled(String dynamicFiled) {
        this.dynamicFiled = dynamicFiled;
    }

    /**
     * @return FILED1
     */
    public String getFiled1() {
        return filed1;
    }

    /**
     * @param filed1
     */
    public void setFiled1(String filed1) {
        this.filed1 = filed1;
    }

    /**
     * @return FILED2
     */
    public String getFiled2() {
        return filed2;
    }

    /**
     * @param filed2
     */
    public void setFiled2(String filed2) {
        this.filed2 = filed2;
    }

    /**
     * @return FILED3
     */
    public String getFiled3() {
        return filed3;
    }

    /**
     * @param filed3
     */
    public void setFiled3(String filed3) {
        this.filed3 = filed3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", datalevel=").append(datalevel);
        sb.append(", status=").append(status);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", type=").append(type);
        sb.append(", email=").append(email);
        sb.append(", tel=").append(tel);
        sb.append(", mobile=").append(mobile);
        sb.append(", address=").append(address);
        sb.append(", zip=").append(zip);
        sb.append(", birthday=").append(birthday);
        sb.append(", cardId=").append(cardId);
        sb.append(", img=").append(img);
        sb.append(", qq=").append(qq);
        sb.append(", weixin=").append(weixin);
        sb.append(", createdate=").append(createdate);
        sb.append(", remark=").append(remark);
        sb.append(", dynamicFiled=").append(dynamicFiled);
        sb.append(", filed1=").append(filed1);
        sb.append(", filed2=").append(filed2);
        sb.append(", filed3=").append(filed3);
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
        BAccount other = (BAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDatalevel() == null ? other.getDatalevel() == null : this.getDatalevel().equals(other.getDatalevel()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getZip() == null ? other.getZip() == null : this.getZip().equals(other.getZip()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getWeixin() == null ? other.getWeixin() == null : this.getWeixin().equals(other.getWeixin()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getDynamicFiled() == null ? other.getDynamicFiled() == null : this.getDynamicFiled().equals(other.getDynamicFiled()))
            && (this.getFiled1() == null ? other.getFiled1() == null : this.getFiled1().equals(other.getFiled1()))
            && (this.getFiled2() == null ? other.getFiled2() == null : this.getFiled2().equals(other.getFiled2()))
            && (this.getFiled3() == null ? other.getFiled3() == null : this.getFiled3().equals(other.getFiled3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDatalevel() == null) ? 0 : getDatalevel().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getZip() == null) ? 0 : getZip().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getWeixin() == null) ? 0 : getWeixin().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDynamicFiled() == null) ? 0 : getDynamicFiled().hashCode());
        result = prime * result + ((getFiled1() == null) ? 0 : getFiled1().hashCode());
        result = prime * result + ((getFiled2() == null) ? 0 : getFiled2().hashCode());
        result = prime * result + ((getFiled3() == null) ? 0 : getFiled3().hashCode());
        return result;
    }
}