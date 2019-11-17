package com.akta.yelp.api.response;

public class ErrorResult<T> implements ApiResult<T> {

  private String error;

  public ErrorResult(String error) {
    this.error = error;
  }

  @Override
  public T getResult() {
    return null;
  }

  @Override
  public ErrorResult<T> getError() {
    return this;
  }

  @Override
  public ExceptionResult<T> getException() {
    return null;
  }

  @Override
  public <R> R visit(Visitor<T, R> visitor) {
    return visitor.caseError(this);
  }

}
