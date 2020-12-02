package com.oijoa.domain;

import java.util.List;

public class Basket {
  private int basketNo;
  private int productNo;
  private int amount;
  private User writer;
  private Product products;
  private List<Product> product;
  private List<User> users;
  
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
  public User getWriter() {
    return writer;
  }
  public void setWriter(User writer) {
    this.writer = writer;
  }
  public Product getProducts() {
    return products;
  }
  public void setProducts(Product products) {
    this.products = products;
  }
  public List<Product> getProduct() {
    return product;
  }
  public void setProduct(List<Product> product) {
    this.product = product;
  }
  public List<User> getUsers() {
    return users;
  }
  public void setUsers(List<User> users) {
    this.users = users;
  }
}
