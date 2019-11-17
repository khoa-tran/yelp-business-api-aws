package com.akta.yelp.api.response;

import static java.util.Objects.nonNull;

import retrofit2.Call;
import retrofit2.Response;

public interface ApiResult<T> {

  T getResult();

  ErrorResult<T> getError();

  ExceptionResult<T> getException();

  <R> R visit(Visitor<T, R> visitor);

  interface Visitor<T, R> {

    R caseSuccess(T result);

    R caseError(ErrorResult<T> error);

    R caseException(ExceptionResult<T> exception);

  }

  static <T> ApiResult<T> execute(Call<T> call) {
    try {
      Response<T> response = call.execute();
      try {
        if (response.isSuccessful()) {
          return new SuccessResult<>(response.body());
        } else {
          return new ErrorResult<>(nonNull(response.errorBody()) ? response.errorBody().string() : response.message());
        }
      } catch (Exception e) {
        return new ExceptionResult<>(response.code(), response.message(), e);
      }
    } catch (Exception e) {
      return new ExceptionResult<>(e);
    }
  }

}
