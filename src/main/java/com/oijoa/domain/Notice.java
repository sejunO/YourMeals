package com.oijoa.domain;

import java.sql.Date;

public class Notice {
  private int noticeNo;
  private int noticeTypeNo;
  private String title;
  private String content;
  private Date registeredDate;
  
  public int getNoticeNo() {
    return noticeNo;
  }
  public void setNoticeNo(int noticeNo) {
    this.noticeNo = noticeNo;
  }
  public int getNoticeTypeNo() {
    return noticeTypeNo;
  }
  public void setNoticeTypeNo(int noticeTypeNo) {
    this.noticeTypeNo = noticeTypeNo;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
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
}
