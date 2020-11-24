package com.oijoa.domain;

public class Product {
  private int productNo;
  private int materialNo;
  private int stock;
  private int price;
  private int discount;
  private String content;
  
  public int getProductNo() {
    return productNo;
  }
  public void setProductNo(int productNo) {
    this.productNo = productNo;
  }
  public int getMaterialNo() {
    return materialNo;
  }
  public void setMaterialNo(int materialNo) {
    this.materialNo = materialNo;
  }
  public int getStock() {
    return stock;
  }
  public void setStock(int stock) {
    this.stock = stock;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getDiscount() {
    return discount;
  }
  public void setDiscount(int discount) {
    this.discount = discount;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
}
