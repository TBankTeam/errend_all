package com.example.entity;

public class Orders {
    /** ID */
    private Integer id;
    /** 订单编号 */
    private String orderNo;
    /** 物品名称 */
    private String name;
    private String descr;
    /** 物品图片 */
    private String img;
    /** 物品图片 */
    private String certificate;
    /** 物品类型 */
    private String type;
    /** 物品重量 */
    private Double weight;
    /** 小费 */
    private int price;
    /** 发起人ID */
    private Integer userId;
    /** 接单人ID */
    private Integer acceptId;
    /** 服务时间 */
    private String serveTime;
    /** 创建时间 */
    private String time;
    /** 接单时间 */
    private String acceptTime;
    /** 接单时间 */
    private String finishTime;
    /** 订单状态 */
    private String status;
    /** 发起人联系ID */
    private Integer addressId;
    /** 到达处联系ID */
    private Integer targetId;
    /** 订单备注 */
    private String comment;

    // 下单人名称
    private String userName;
    // 接单人名称
    private String acceptName;

    // 已下单多少分钟
    private Integer range;

    // 取货地址
    private Address address;

    // 收货地址
    private Address targetAddress;

    // 骑手信息
    private Certification certification;

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(Address targetAddress) {
        this.targetAddress = targetAddress;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAcceptName() {
        return acceptName;
    }

    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getServeTime() {
        return serveTime;
    }

    public void setServeTime(String serveTime) {
        this.serveTime = serveTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", img='" + img + '\'' +
                ", certificate='" + certificate + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", userId=" + userId +
                ", acceptId=" + acceptId +
                ", serveTime='" + serveTime + '\'' +
                ", time='" + time + '\'' +
                ", acceptTime='" + acceptTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", status='" + status + '\'' +
                ", addressId=" + addressId +
                ", targetId=" + targetId +
                ", comment='" + comment + '\'' +
                ", userName='" + userName + '\'' +
                ", acceptName='" + acceptName + '\'' +
                ", range=" + range +
                ", address=" + address +
                ", targetAddress=" + targetAddress +
                ", certification=" + certification +
                '}';
    }
}
