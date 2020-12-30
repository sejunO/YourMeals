package com.oijoa.domain;

import java.sql.Date;
import java.util.List;

public class Order {
  private int orderNo;
  private User userNo;
  private int paymentNo;
  private int deliveryCompanyNo;
  private int transportNo;
  private int postNo;
  private int status;
  private String memo;
  private Date orderDate;
  private String address;
  private String detailAddress;
  private Basket basket;
  private List<Basket> baskets;
  private List<Product> products;
  private List<OrderList> orderLists;
  private List<DeliveryCompany> company;
  private int totalPrice;
  private String tel;

  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public int getTotalPrice() {
    return totalPrice;
  }
  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }
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
  public int getDeliveryCompanyNo() {
    return deliveryCompanyNo;
  }
  public void setDeliveryCompanyNo(int deliveryCompanyNo) {
    this.deliveryCompanyNo = deliveryCompanyNo;
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
  public List<Product> getProducts() {
    return products;
  }
  public void setProducts(List<Product> products) {
    this.products = products;
  }
  public List<OrderList> getOrderLists() {
    return orderLists;
  }
  public void setOrderLists(List<OrderList> orderLists) {
    this.orderLists = orderLists;
  }
  public List<DeliveryCompany> getCompany() {
    return company;
  }
  public void setCompany(List<DeliveryCompany> company) {
    this.company = company;
  }
}

