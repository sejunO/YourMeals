package com.oijoa.domain;

public class Product {
  private int productNo;
  private Material material;
  private int stock;
  private int price;
  private int discount;
  private String content;
  private String photo;

  public int getProductNo() {
    return productNo;
  }
  public void setProductNo(int productNo) {
    this.productNo = productNo;
  }
  public Material getMaterial() {
    return material;
  }
  public void setMaterial(Material material) {
    this.material = material;
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
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
}
