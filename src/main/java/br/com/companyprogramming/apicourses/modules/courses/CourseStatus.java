package br.com.companyprogramming.apicourses.modules.courses;

public enum CourseStatus {
  INACTIVE(false),
  ACTIVE(true);

  private final boolean value;

  CourseStatus(boolean value) {
    this.value = value;
  }

  public boolean getValue() {
    return value;
  }
}
