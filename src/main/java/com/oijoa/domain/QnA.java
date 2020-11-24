package com.oijoa.domain;

import java.sql.Date;

public class QnA {
  private int QnaNo;
  private int userNo;
  private int secret;
  private String content;
  private Date createdDate;
  private String answer;
  private Date answerDate;
  
  public int getQnaNo() {
    return QnaNo;
  }
  public void setQnaNo(int qnaNo) {
    QnaNo = qnaNo;
  }
  public int getUserNo() {
    return userNo;
  }
  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }
  public int getSecret() {
    return secret;
  }
  public void setSecret(int secret) {
    this.secret = secret;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public String getAnswer() {
    return answer;
  }
  public void setAnswer(String answer) {
    this.answer = answer;
  }
  public Date getAnswerDate() {
    return answerDate;
  }
  public void setAnswerDate(Date answerDate) {
    this.answerDate = answerDate;
  }
}
