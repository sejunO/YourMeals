package com.oijoa.domain;

public class RecipeStep {
  private int stepNo;
  private int recipeNo;
  private int step;
  private String photo;
  private String content;

  public int getStepNo() {
    return stepNo;
  }

  public void setStepNo(int stepNo) {
    this.stepNo = stepNo;
  }

  public int getRecipeNo() {
    return recipeNo;
  }

  public void setRecipeNo(int recipeNo) {
    this.recipeNo = recipeNo;
  }

  public int getStep() {
    return step;
  }

  public void setStep(int step) {
    this.step = step;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
