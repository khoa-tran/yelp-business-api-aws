package com.akta.yelp.api.response;

public class SuccessResult<T> implements ApiResult<T> {

  private T result;

  public SuccessResult(T result) {
    this.result = result;
  }

  @Override
  public T getResult() {
    return result;
  }

  @Override
  public ErrorResult<T> getError() {
    return null;
  }

  @Override
  public ExceptionResult<T> getException() {
    return null;
  }

  @Override
  public <R> R visit(Visitor<T, R> visitor) {
    return visitor.caseSuccess(result);
  }

}
