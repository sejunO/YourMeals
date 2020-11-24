package com.oijoa.domain;

import java.sql.Date;

public class Comment {
  private int commentNo;
  private int userNo;
  private int recipeNo;
  private String content;
  private Date creadtedDate;
  private Date modifiedDate;
  
  public int getCommentNo() {
    return commentNo;
  }
  public void setCommentNo(int commentNo) {
    this.commentNo = commentNo;
  }
  public int getUserNo() {
    return userNo;
  }
  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }
  public int getRecipeNo() {
    return recipeNo;
  }
  public void setRecipeNo(int recipeNo) {
    this.recipeNo = recipeNo;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getCreadtedDate() {
    return creadtedDate;
  }
  public void setCreadtedDate(Date creadtedDate) {
    this.creadtedDate = creadtedDate;
  }
  public Date getModifiedDate() {
    return modifiedDate;
  }
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }
}
