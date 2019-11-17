package com.akta.yelp.api.response;

import java.util.Optional;

public class ErrorResult<T> implements ApiResult<T> {

  private String error;

  public ErrorResult(String error) {
    this.error = error;
  }

  @Override
  public Optional<T> getResult() {
    return Optional.empty();
  }

  @Override
  public Optional<ErrorResult<T>> getError() {
    return Optional.of(this);
  }

  @Override
  public Optional<ExceptionResult<T>> getException() {
    return Optional.empty();
  }

  @Override
  public <R> R visit(Visitor<T, R> visitor) {
    return visitor.caseError(this);
  }

}
