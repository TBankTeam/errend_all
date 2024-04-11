package com.example.entity;

import java.math.BigDecimal;

/**
 * 角色用户父类
 */
public class Account {
    private Integer id;
    /** 用户名 */
    private String username;
    /** 名称 */
    private String name;
    /** 密码 */
    private String password;
    /** 角色标识 */
    private String role;
    /** 新密码 */
    private String newPassword;
    /** 头像 */
    private String avatar;

    private String token;

    private Integer account;

    private Integer availableFunds;

    private Boolean isRider;  // 是否是骑手

    public Boolean getIsRider() {
        return isRider;
    }

    public void setIsRider(Boolean isRider) {
        this.isRider = isRider;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", avatar='" + avatar + '\'' +
                ", token='" + token + '\'' +
                ", account=" + account +
                ", availableFunds=" + availableFunds +
                ", isRider=" + isRider +
                '}';
    }
}
