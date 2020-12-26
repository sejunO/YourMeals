package com.oijoa.domain;

import java.sql.Date;

public class Notice {
  private int noticeNo;
  private NoticeType noticeType;
  private String title;
  private String content;
  private Date registeredDate;

  public int getNoticeNo() {
    return noticeNo;
  }

  public void setNoticeNo(int noticeNo) {
    this.noticeNo = noticeNo;
  }

  public NoticeType getNoticeType() {
    return noticeType;
  }

  public void setNoticeType(NoticeType noticeType) {
    this.noticeType = noticeType;
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
