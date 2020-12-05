package com.oijoa.domain;

import java.sql.Date;

public class Qna {
  private int QnaNo;
  private User writer;
  private int secret;
  private String title;
  private String content;
  private Date createdDate;
  private String answerStatus;
  private String answer;
  private Date answerDate;

  public int getQnaNo() {
    return QnaNo;
  }
  public void setQnaNo(int qnaNo) {
    QnaNo = qnaNo;
  }
  public User getWriter() {
    return writer;
  }
  public void setWriter(User writer) {
    this.writer = writer;
  }
  public int getSecret() {
    return secret;
  }
  public void setSecret(int secret) {
    this.secret = secret;
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
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public String getAnswerStatus() {
    return answerStatus;
  }
  public void setAnswerStatus(String answerStatus) {
    this.answerStatus = answerStatus;
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
