package com.akta.yelp.api.response;

public class ExceptionResult<T> implements ApiResult<T> {

  private Integer maybeStatusCode;
  private String maybeBody;
  private Exception exception;

  public ExceptionResult(Exception exception) {
    this.exception = exception;
  }

  public ExceptionResult(Integer maybeStatusCode, String maybeBody, Exception exception) {
    this.maybeStatusCode = maybeStatusCode;
    this.maybeBody = maybeBody;
    this.exception = exception;
  }

  @Override
  public T getResult() {
    return null;
  }

  @Override
  public ErrorResult<T> getError() {
    return null;
  }

  @Override
  public ExceptionResult<T> getException() {
    return this;
  }

  @Override
  public <R> R visit(Visitor<T, R> visitor) {
    return visitor.caseException(this);
  }

}
