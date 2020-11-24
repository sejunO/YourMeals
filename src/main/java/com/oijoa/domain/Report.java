package com.oijoa.domain;

import java.sql.Date;

public class Report {
  private int reportNo;
  private int reporter;
  private int attacker;
  private int reprotTypeNo;
  private String content;
  private Date registeredDate;
  private int stat;
  
  public int getReportNo() {
    return reportNo;
  }
  public void setReportNo(int reportNo) {
    this.reportNo = reportNo;
  }
  public int getReporter() {
    return reporter;
  }
  public void setReporter(int reporter) {
    this.reporter = reporter;
  }
  public int getAttacker() {
    return attacker;
  }
  public void setAttacker(int attacker) {
    this.attacker = attacker;
  }
  public int getReprotTypeNo() {
    return reprotTypeNo;
  }
  public void setReprotTypeNo(int reprotTypeNo) {
    this.reprotTypeNo = reprotTypeNo;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
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
}
