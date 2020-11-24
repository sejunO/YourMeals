package com.oijoa.domain;

import java.sql.Date;

public class KakaoPay {
  private int orderNo;
  private String name;
  private String account;
  private Date transferedDate;
  
  public int getOrderNo() {
    return orderNo;
  }
  public void setOrderNo(int orderNo) {
    this.orderNo = orderNo;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }
  public Date getTransferedDate() {
    return transferedDate;
  }
  public void setTransferedDate(Date transferedDate) {
    this.transferedDate = transferedDate;
  }
}
