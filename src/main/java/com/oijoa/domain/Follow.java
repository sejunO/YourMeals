package com.oijoa.domain;

public class Follow {
  private int follower;
  private int following;
  private User User;

  public int getFollower() {
    return follower;
  }
  public void setFollower(int follower) {
    this.follower = follower;
  }
  public int getFollowing() {
    return following;
  }
  public void setFollowing(int following) {
    this.following = following;
  }
  public User getUser() {
    return User;
  }
  public void setUser(User user) {
    User = user;
  }
}
