package com.oijoa.domain;

import java.sql.Date;

public class MyBuyList {
  private int orderNo;
  private User userNo;
  private Date orderDate;
  private int deliveryCompanyNo;
  private String deliveryCompanyName;
  private int postNo;
  private String address;
  private String detailAddress;
  private String photo;
  private int status;
  
  public int getOrderNo() {
    return orderNo;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public void setOrderNo(int orderNo) {
    this.orderNo = orderNo;
  }
  public User getUserNo() {
    return userNo;
  }
  public void setUserNo(User userNo) {
    this.userNo = userNo;
  }
  public Date getOrderDate() {
    return orderDate;
  }
  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }
  public int getDeliveryCompanyNo() {
    return deliveryCompanyNo;
  }
  public void setDeliveryCompanyNo(int deliveryCompanyNo) {
    this.deliveryCompanyNo = deliveryCompanyNo;
  }
  public String getDeliveryCompanyName() {
    return deliveryCompanyName;
  }
  public void setDeliveryCompanyName(String deliveryCompanyName) {
    this.deliveryCompanyName = deliveryCompanyName;
  }
  public int getPostNo() {
    return postNo;
  }
  public void setPostNo(int postNo) {
    this.postNo = postNo;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getDetailAddress() {
    return detailAddress;
  }
  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  
}
