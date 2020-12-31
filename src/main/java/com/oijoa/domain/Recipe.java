package com.oijoa.domain;

import java.sql.Date;

public class Recipe {

  private int recipeNo;
  private User writer;
  private String title;
  private String content;
  private String photo;
  private int hits;
  private int recommendCount;
  private int recommendCountCheck;
  private Date createdDate;
  private Date modifiedDate;
  private int min;
  private int levelNo;
  private Category category;
  private int serving;



  public int getRecipeNo() {
    return recipeNo;
  }

  public void setRecipeNo(int recipeNo) {
    this.recipeNo = recipeNo;
  }

  public User getWriter() {
    return writer;
  }

  public void setWriter(User writer) {
    this.writer = writer;
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

  public int getRecommendCount() {
    return recommendCount;
  }

  public void setRecommendCount(int recommendCount) {
    this.recommendCount = recommendCount;
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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public int getServing() {
    return serving;
  }

  public void setServing(int serving) {
    this.serving = serving;
  }

  public int getRecommendCountCheck() {
    return recommendCountCheck;
  }

  public void setRecommendCountCheck(int recommendCountCheck) {
    this.recommendCountCheck = recommendCountCheck;
  }
  

}
