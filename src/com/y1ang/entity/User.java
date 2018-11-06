package com.y1ang.entity;

import java.util.Date;

/**
 * 
 * @author y1ang
 * @Data 2018年10月2日-下午4:58:52
 * @Description 用户POJO类
 */

public class User {

    private int userId;
    private String userName;
    private String userPwd;
    private String phone;
    private Date createDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User(String userName, String userPwd, String phone, Date createDate) {
        super();
        this.userName = userName;
        this.userPwd = userPwd;
        this.phone = phone;
        this.createDate = createDate;
    }

    public User(int userId, String userName, String userPwd, String phone, Date createDate) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.phone = phone;
        this.createDate = createDate;
    }

    public User() {
        super();
    }

    public User(String userName, String userPwd) {
        super();
        this.userName = userName;
        this.userPwd = userPwd;
    }
}
