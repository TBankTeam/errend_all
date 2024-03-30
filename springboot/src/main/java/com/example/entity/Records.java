package com.example.entity;

import java.math.BigDecimal;

public class Records {
    /** ID */
    private Integer id;
    /** 事件 */
    private String content;
    /** 金额 */
    private BigDecimal money;
    /** 用户 */
    private Integer userId;
    /** 志愿者 */
    private Integer acceptId;
    /** 时间 */
    private String time;
    /** 类型 */
    private String type;
    private String userName;
    private String acceptName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(Integer acceptId) {
        this.acceptId = acceptId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getAcceptName() {
        return acceptName;
    }

    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }
}
