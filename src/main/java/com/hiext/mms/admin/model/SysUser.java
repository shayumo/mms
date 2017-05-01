package com.hiext.mms.admin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "Sys_User")
public class SysUser implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登陆用户名
     */
    @Column(name = "Account")
    private String account;

    /**
     * 名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * 性别 性别(0:未知;1:男;2:女)
     */
    @Column(name = "Sex")
    private Short sex;

    /**
     * 密码
     */
    @Column(name = "Password")
    private String password;

    /**
     * 人员类型 人员类型(1:管理员;2:员工;)
     */
    @Column(name = "User_Type")
    private Short userType;

    /**
     * 电话
     */
    @Column(name = "Phone")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "Email")
    private String email;

    /**
     * 出生日期
     */
    @Column(name = "Birth_Day")
    private Date birthDay;

    /**
     * 部门编号
     */
    @Column(name = "Dept_Id")
    private BigDecimal deptId;

    /**
     * 职位
     */
    @Column(name = "Position")
    private String position;

    /**
     * 详细地址
     */
    @Column(name = "Address")
    private String address;

    /**
     * 工号
     */
    @Column(name = "Staff_No")
    private String staffNo;

    /**
     * 创建人编号
     */
    @Column(name = "CreatorId")
    private Integer creatorid;

    /**
     * 创建人姓名
     */
    @Column(name = "CreatorName")
    private String creatorname;

    /**
     * 创建日期
     */
    @Column(name = "CreateDate")
    private Date createdate;

    /**
     * 数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     */
    @Column(name = "DataLevel")
    private Integer datalevel;

    /**
     * 排序号
     */
    @Column(name = "OrderNo")
    private Double orderno;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return Id - 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取登陆用户名
     *
     * @return Account - 登陆用户名
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置登陆用户名
     *
     * @param account 登陆用户名
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取名称
     *
     * @return Name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别 性别(0:未知;1:男;2:女)
     *
     * @return Sex - 性别 性别(0:未知;1:男;2:女)
     */
    public Short getSex() {
        return sex;
    }

    /**
     * 设置性别 性别(0:未知;1:男;2:女)
     *
     * @param sex 性别 性别(0:未知;1:男;2:女)
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * 获取密码
     *
     * @return Password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取人员类型 人员类型(1:管理员;2:员工;)
     *
     * @return User_Type - 人员类型 人员类型(1:管理员;2:员工;)
     */
    public Short getUserType() {
        return userType;
    }

    /**
     * 设置人员类型 人员类型(1:管理员;2:员工;)
     *
     * @param userType 人员类型 人员类型(1:管理员;2:员工;)
     */
    public void setUserType(Short userType) {
        this.userType = userType;
    }

    /**
     * 获取电话
     *
     * @return Phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return Email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取出生日期
     *
     * @return Birth_Day - 出生日期
     */
    public Date getBirthDay() {
        return birthDay;
    }

    /**
     * 设置出生日期
     *
     * @param birthDay 出生日期
     */
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * 获取部门编号
     *
     * @return Dept_Id - 部门编号
     */
    public BigDecimal getDeptId() {
        return deptId;
    }

    /**
     * 设置部门编号
     *
     * @param deptId 部门编号
     */
    public void setDeptId(BigDecimal deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取职位
     *
     * @return Position - 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位
     *
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取详细地址
     *
     * @return Address - 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     *
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取工号
     *
     * @return Staff_No - 工号
     */
    public String getStaffNo() {
        return staffNo;
    }

    /**
     * 设置工号
     *
     * @param staffNo 工号
     */
    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    /**
     * 获取创建人编号
     *
     * @return CreatorId - 创建人编号
     */
    public Integer getCreatorid() {
        return creatorid;
    }

    /**
     * 设置创建人编号
     *
     * @param creatorid 创建人编号
     */
    public void setCreatorid(Integer creatorid) {
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
    public Integer getDatalevel() {
        return datalevel;
    }

    /**
     * 设置数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     *
     * @param datalevel 数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     */
    public void setDatalevel(Integer datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * 获取排序号
     *
     * @return OrderNo - 排序号
     */
    public Double getOrderno() {
        return orderno;
    }

    /**
     * 设置排序号
     *
     * @param orderno 排序号
     */
    public void setOrderno(Double orderno) {
        this.orderno = orderno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", password=").append(password);
        sb.append(", userType=").append(userType);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", birthDay=").append(birthDay);
        sb.append(", deptId=").append(deptId);
        sb.append(", position=").append(position);
        sb.append(", address=").append(address);
        sb.append(", staffNo=").append(staffNo);
        sb.append(", creatorid=").append(creatorid);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", createdate=").append(createdate);
        sb.append(", datalevel=").append(datalevel);
        sb.append(", orderno=").append(orderno);
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
        SysUser other = (SysUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getBirthDay() == null ? other.getBirthDay() == null : this.getBirthDay().equals(other.getBirthDay()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getStaffNo() == null ? other.getStaffNo() == null : this.getStaffNo().equals(other.getStaffNo()))
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getDatalevel() == null ? other.getDatalevel() == null : this.getDatalevel().equals(other.getDatalevel()))
            && (this.getOrderno() == null ? other.getOrderno() == null : this.getOrderno().equals(other.getOrderno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getBirthDay() == null) ? 0 : getBirthDay().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getStaffNo() == null) ? 0 : getStaffNo().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getDatalevel() == null) ? 0 : getDatalevel().hashCode());
        result = prime * result + ((getOrderno() == null) ? 0 : getOrderno().hashCode());
        return result;
    }
}