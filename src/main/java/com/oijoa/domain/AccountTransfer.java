package com.oijoa.domain;

import java.sql.Date;

public class AccountTransfer {
  private int orderNo;
  private String userName;
  private String account;
  private Date transferedDate;
  private String bankName;
  public int getOrderNo() {
    return orderNo;
  }
  public void setOrderNo(int orderNo) {
    this.orderNo = orderNo;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
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
  public String getBankName() {
    return bankName;
  }
  public void setBankName(String bankName) {
    this.bankName = bankName;
  }


}
