package com.oijoa.domain;

import java.util.List;

public class Basket {
  private int basketNo;
  private int productNo;
  private int amount;
  private int userNo;
  private Product products;
  private List<Product> product;
  private List<User> users;

  public List<Product> getProduct() {
    return product;
  }
  public void setProduct(List<Product> product) {
    this.product = product;
  }

  public Product getProducts() {
    return products;
  }
  public void setProducts(Product products) {
    this.products = products;
  }
  public List<User> getUsers() {
    return users;
  }
  public void setUsers(List<User> users) {
    this.users = users;
  }

  public int getBasketNo() {
    return basketNo;
  }
  public void setBasketNo(int basketNo) {
    this.basketNo = basketNo;
  }
  public int getProductNo() {
    return productNo;
  }
  public void setProductNo(int productNo) {
    this.productNo = productNo;
  }
  public int getAmount() {
    return amount;
  }
  public void setAmount(int amount) {
    this.amount = amount;
  }
  public int getUserNo() {
    return userNo;
  }
  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }
}
