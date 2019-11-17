package com.akta.yelp.api.response;

import java.util.Optional;

public class SuccessResult<T> implements ApiResult<T> {

  private T result;

  public SuccessResult(T result) {
    this.result = result;
  }

  @Override
  public Optional<T> getResult() {
    return Optional.of(result);
  }

  @Override
  public Optional<ErrorResult<T>> getError() {
    return Optional.empty();
  }

  @Override
  public Optional<ExceptionResult<T>> getException() {
    return Optional.empty();
  }

  @Override
  public <R> R visit(Visitor<T, R> visitor) {
    return visitor.caseSuccess(result);
  }
  
}
