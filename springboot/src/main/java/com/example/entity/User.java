package com.example.entity;

import java.math.BigDecimal;
import java.util.Date;

public class User extends Account {

    /** ID */
    private Integer id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 姓名 */
    private String name;
    /** 身份证号 */
    private String idNumber;
    /** 电话 */
    private String phone;
    /** 头像 */
    private String avatar;
    /** 角色标识 */
    private String role;
    /** 年龄 */
    private Integer age;
    /** 性别 */
    private String sex;
    /** 注册时间 */
    private Date registerTime;
    /** 登陆时间 */
    private Date loginTime;
    /** 修改时间 */
    private Date updateTime;
    /** 资金账户 */
    private String accountAddress;
    /** 身份认证id */
    private String weid;
    /** 账户余额 */
    private Integer account;
    /** 可用资金 */
    private Integer availableFunds;
    /** 订单推荐序列 */
    private String recommendList;
    /** 状态 */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Integer getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(Integer availableFunds) {
        this.availableFunds = availableFunds;
    }

    public String getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(String recommendList) {
        this.recommendList = recommendList;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", role='" + role + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", registerTime=" + registerTime +
                ", loginTime=" + loginTime +
                ", updateTime=" + updateTime +
                ", accountAddress='" + accountAddress + '\'' +
                ", weid='" + weid + '\'' +
                ", account=" + account +
                ", availableFunds=" + availableFunds +
                ", recommendList=" + recommendList +
                ", status=" + status +
                '}';
    }
}
