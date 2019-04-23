package com.benjamin.hcc.core;

import java.util.Date;
import java.util.UUID;

/**
 * @Auther Benjamin(Jingyi Li) Li
 * @Email jili@student.unimelb.edu.au
 * @ID 961543
 * @Date 2019-04-22 18:06
 */
public abstract class BaseDTO {

    public BaseDTO(){
        this.id = UUID.randomUUID().toString();
        this.deleted = false;
//        try {
//            UserContextDTO userContextDTO = (UserContextDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            this.createUser = userContextDTO.getUsername();
//        } catch (Exception e) {
//            this.createUser = "dev";
//        }
        this.createTime = new Date();
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "id='" + id + '\'' +
                ", deleted=" + deleted +
//                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                '}';
    }

    private String id;
    private Boolean deleted;
    private Date createTime;
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}