package com.akta.yelp.api.response;

import java.util.Optional;

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
  public Optional<T> getResult() {
    return Optional.empty();
  }

  @Override
  public Optional<ErrorResult<T>> getError() {
    return Optional.empty();
  }

  @Override
  public Optional<ExceptionResult<T>> getException() {
    return Optional.of(this);
  }

  @Override
  public <R> R visit(Visitor<T, R> visitor) {
    return visitor.caseException(this);
  }

}
