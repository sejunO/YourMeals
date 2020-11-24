package com.oijoa.domain;

import java.sql.Date;

public class Refund {
  private int orderNo;
  private Date registeredDate;
  private int stat;
  private Date processedDate;
  private String rsn;
  
  public int getOrderNo() {
    return orderNo;
  }
  public void setOrderNo(int orderNo) {
    this.orderNo = orderNo;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getStat() {
    return stat;
  }
  public void setStat(int stat) {
    this.stat = stat;
  }
  public Date getProcessedDate() {
    return processedDate;
  }
  public void setProcessedDate(Date processedDate) {
    this.processedDate = processedDate;
  }
  public String getRsn() {
    return rsn;
  }
  public void setRsn(String rsn) {
    this.rsn = rsn;
  }
}
