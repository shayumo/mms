package com.hiext.mms.admin.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "Sys_Role")
public class SysRole implements Serializable {
    /**
     * 角色编号
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "Role_Name")
    private String roleName;

    /**
     * 角色类型 角色类型(1:业务角色;2:管理角色;3:系统内置角色)
     */
    @Column(name = "Role_Type")
    private Boolean roleType;

    /**
     * 备注
     */
    @Column(name = "Remark_")
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
    private Date createdate;

    /**
     * 数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     */
    @Column(name = "DataLevel")
    private Boolean datalevel;

    /**
     * 排序号
     */
    @Column(name = "OrderNo")
    private Integer orderno;

    private static final long serialVersionUID = 1L;

    /**
     * 获取角色编号
     *
     * @return Id - 角色编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置角色编号
     *
     * @param id 角色编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return Role_Name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色类型 角色类型(1:业务角色;2:管理角色;3:系统内置角色)
     *
     * @return Role_Type - 角色类型 角色类型(1:业务角色;2:管理角色;3:系统内置角色)
     */
    public Boolean getRoleType() {
        return roleType;
    }

    /**
     * 设置角色类型 角色类型(1:业务角色;2:管理角色;3:系统内置角色)
     *
     * @param roleType 角色类型 角色类型(1:业务角色;2:管理角色;3:系统内置角色)
     */
    public void setRoleType(Boolean roleType) {
        this.roleType = roleType;
    }

    /**
     * 获取备注
     *
     * @return Remark_ - 备注
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
    public Boolean getDatalevel() {
        return datalevel;
    }

    /**
     * 设置数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     *
     * @param datalevel 数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿
     */
    public void setDatalevel(Boolean datalevel) {
        this.datalevel = datalevel;
    }

    /**
     * 获取排序号
     *
     * @return OrderNo - 排序号
     */
    public Integer getOrderno() {
        return orderno;
    }

    /**
     * 设置排序号
     *
     * @param orderno 排序号
     */
    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleType=").append(roleType);
        sb.append(", remark=").append(remark);
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
        SysRole other = (SysRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getRoleType() == null ? other.getRoleType() == null : this.getRoleType().equals(other.getRoleType()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getRoleType() == null) ? 0 : getRoleType().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getDatalevel() == null) ? 0 : getDatalevel().hashCode());
        result = prime * result + ((getOrderno() == null) ? 0 : getOrderno().hashCode());
        return result;
    }
}