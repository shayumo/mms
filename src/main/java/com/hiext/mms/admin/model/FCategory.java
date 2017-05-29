package com.hiext.mms.admin.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "f_category")
public class FCategory implements Serializable {
    /**
     * 编号
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父编号
     */
    @Column(name = "Pid")
    private Long pid;

    /**
     * 名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * 注释
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
     * 获取父编号
     *
     * @return Pid - 父编号
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父编号
     *
     * @param pid 父编号
     */
    public void setPid(Long pid) {
        this.pid = pid;
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
     * 获取注释
     *
     * @return remark - 注释
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置注释
     *
     * @param remark 注释
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
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
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
        FCategory other = (FCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
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
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }
}