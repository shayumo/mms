package com.hiext.mms.admin.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "Sys_Menu")
public class SysMenu implements Serializable {
    /**
     * 菜单编号
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 菜单名称
     */
    @Column(name = "Menu_Name")
    private String menuName;

    /**
     * 菜单类型 菜单类型(0:CURD;1:系统菜单;2:业务菜单;)
     */
    @Column(name = "Menu_Type")
    private Boolean menuType;

    /**
     * 上级菜单编号
     */
    @Column(name = "Parent_Id")
    private Long parentId;

    /**
     * 节点图标CSS类名
     */
    @Column(name = "ICOnCls")
    private String iconcls;

    /**
     * 请求地址
     */
    @Column(name = "Request_URL")
    private String requestUrl;

    /**
     * 排序号
     */
    @Column(name = "Sort_No")
    private Long sortNo;

    /**
     * 备注
     */
    @Column(name = "Remark")
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
    private Double orderno;

    private static final long serialVersionUID = 1L;

    /**
     * 获取菜单编号
     *
     * @return Id - 菜单编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置菜单编号
     *
     * @param id 菜单编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取菜单名称
     *
     * @return Menu_Name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取菜单类型 菜单类型(0:CURD;1:系统菜单;2:业务菜单;)
     *
     * @return Menu_Type - 菜单类型 菜单类型(0:CURD;1:系统菜单;2:业务菜单;)
     */
    public Boolean getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型 菜单类型(0:CURD;1:系统菜单;2:业务菜单;)
     *
     * @param menuType 菜单类型 菜单类型(0:CURD;1:系统菜单;2:业务菜单;)
     */
    public void setMenuType(Boolean menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取上级菜单编号
     *
     * @return Parent_Id - 上级菜单编号
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级菜单编号
     *
     * @param parentId 上级菜单编号
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取节点图标CSS类名
     *
     * @return ICOnCls - 节点图标CSS类名
     */
    public String getIconcls() {
        return iconcls;
    }

    /**
     * 设置节点图标CSS类名
     *
     * @param iconcls 节点图标CSS类名
     */
    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    /**
     * 获取请求地址
     *
     * @return Request_URL - 请求地址
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * 设置请求地址
     *
     * @param requestUrl 请求地址
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    /**
     * 获取排序号
     *
     * @return Sort_No - 排序号
     */
    public Long getSortNo() {
        return sortNo;
    }

    /**
     * 设置排序号
     *
     * @param sortNo 排序号
     */
    public void setSortNo(Long sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
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
        sb.append(", menuName=").append(menuName);
        sb.append(", menuType=").append(menuType);
        sb.append(", parentId=").append(parentId);
        sb.append(", iconcls=").append(iconcls);
        sb.append(", requestUrl=").append(requestUrl);
        sb.append(", sortNo=").append(sortNo);
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
        SysMenu other = (SysMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuType() == null ? other.getMenuType() == null : this.getMenuType().equals(other.getMenuType()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getIconcls() == null ? other.getIconcls() == null : this.getIconcls().equals(other.getIconcls()))
            && (this.getRequestUrl() == null ? other.getRequestUrl() == null : this.getRequestUrl().equals(other.getRequestUrl()))
            && (this.getSortNo() == null ? other.getSortNo() == null : this.getSortNo().equals(other.getSortNo()))
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
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuType() == null) ? 0 : getMenuType().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getIconcls() == null) ? 0 : getIconcls().hashCode());
        result = prime * result + ((getRequestUrl() == null) ? 0 : getRequestUrl().hashCode());
        result = prime * result + ((getSortNo() == null) ? 0 : getSortNo().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getDatalevel() == null) ? 0 : getDatalevel().hashCode());
        result = prime * result + ((getOrderno() == null) ? 0 : getOrderno().hashCode());
        return result;
    }
}