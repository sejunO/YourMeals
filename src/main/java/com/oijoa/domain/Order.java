package com.oijoa.domain;

import java.sql.Date;
import java.util.List;

public class Order {
  private int orderNo;
  private User userNo;
  private int paymentNo;
  private int deleveryCompanyNo;
  private int transportNo;
  private int postNo;
  private int status;
  private String memo;
  private Date orderDate;
  private String address;
  private String detailAddress;
  private Basket basket;
  private List<Basket> baskets;
  public int getOrderNo() {
    return orderNo;
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
  public int getPaymentNo() {
    return paymentNo;
  }
  public void setPaymentNo(int paymentNo) {
    this.paymentNo = paymentNo;
  }
  public int getDeleveryCompanyNo() {
    return deleveryCompanyNo;
  }
  public void setDeleveryCompanyNo(int deleveryCompanyNo) {
    this.deleveryCompanyNo = deleveryCompanyNo;
  }
  public int getTransportNo() {
    return transportNo;
  }
  public void setTransportNo(int transportNo) {
    this.transportNo = transportNo;
  }
  public int getPostNo() {
    return postNo;
  }
  public void setPostNo(int postNo) {
    this.postNo = postNo;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getMemo() {
    return memo;
  }
  public void setMemo(String memo) {
    this.memo = memo;
  }
  public Date getOrderDate() {
    return orderDate;
  }
  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
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
  public Basket getBasket() {
    return basket;
  }
  public void setBasket(Basket basket) {
    this.basket = basket;
  }
  public List<Basket> getBaskets() {
    return baskets;
  }
  public void setBaskets(List<Basket> baskets) {
    this.baskets = baskets;
  }

}






