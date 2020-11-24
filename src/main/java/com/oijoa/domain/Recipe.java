package com.oijoa.domain;

import java.sql.Date;

public class Recipe {
  private int recipeNo;
  private int userNo;
  private String title;
  private String content;
  private String photo;
  private int hits;
  private int recomendCount;
  private Date createdDate;
  private Date modifiedDate;
  private int min;
  private int levelNo;
  
  public int getRecipeNo() {
    return recipeNo;
  }
  public void setRecipeNo(int recipeNo) {
    this.recipeNo = recipeNo;
  }
  public int getUserNo() {
    return userNo;
  }
  public void setUserNo(int userNo) {
    this.userNo = userNo;
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
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public int getHits() {
    return hits;
  }
  public void setHits(int hits) {
    this.hits = hits;
  }
  public int getRecomendCount() {
    return recomendCount;
  }
  public void setRecomendCount(int recomendCount) {
    this.recomendCount = recomendCount;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public Date getModifiedDate() {
    return modifiedDate;
  }
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }
  public int getMin() {
    return min;
  }
  public void setMin(int min) {
    this.min = min;
  }
  public int getLevelNo() {
    return levelNo;
  }
  public void setLevelNo(int levelNo) {
    this.levelNo = levelNo;
  }
}
