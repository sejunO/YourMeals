package com.oijoa.domain;

public class OrderList {
  private int orderListNo;
  private Order orderNo;
  private Product productNo;
  private int amount;
  private int discount;
  private int price;
  private Basket basket;

  public Product getProductNo() {
    return productNo;
  }
  public void setProductNo(Product productNo) {
    this.productNo = productNo;
  }
  public Order getOrderNo() {
    return orderNo;
  }
  public void setOrderNo(Order orderNo) {
    this.orderNo = orderNo;
  }
  public Basket getBasket() {
    return basket;
  }
  public void setBasket(Basket basket) {
    this.basket = basket;
  }
  public int getOrderListNo() {
    return orderListNo;
  }
  public void setOrderListNo(int orderListNo) {
    this.orderListNo = orderListNo;
  }
  public int getAmount() {
    return amount;
  }
  public void setAmount(int amount) {
    this.amount = amount;
  }
  public int getDiscount() {
    return discount;
  }
  public void setDiscount(int discount) {
    this.discount = discount;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
}






