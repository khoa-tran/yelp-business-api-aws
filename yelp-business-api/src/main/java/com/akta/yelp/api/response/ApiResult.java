package com.akta.yelp.api.response;

import java.util.Optional;

public interface ApiResult<T> {

  Optional<T> getResult();

  Optional<ErrorResult<T>> getError();

  Optional<ExceptionResult<T>> getException();

  <R> R visit(Visitor<T, R> visitor);

  interface Visitor<T, R> {

    R caseSuccess(T result);

    R caseError(ErrorResult<T> error);

    R caseException(ExceptionResult<T> exception);

  }

}
