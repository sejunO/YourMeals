package com.oijoa.domain;

public class OrderList {
  private int orderListNo;
  private Order orderNo;
  private Product orderProduct;
  private int amount;
  private int discount;
  private int price;
  private Basket basket;

  public int getOrderListNo() {
    return orderListNo;
  }
  public void setOrderListNo(int orderListNo) {
    this.orderListNo = orderListNo;
  }
  public Order getOrderNo() {
    return orderNo;
  }
  public void setOrderNo(Order orderNo) {
    this.orderNo = orderNo;
  }
  public Product getOrderProduct() {
    return orderProduct;
  }
  public void setOrderProduct(Product orderProduct) {
    this.orderProduct = orderProduct;
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
  public Basket getBasket() {
    return basket;
  }
  public void setBasket(Basket basket) {
    this.basket = basket;
  }
}
