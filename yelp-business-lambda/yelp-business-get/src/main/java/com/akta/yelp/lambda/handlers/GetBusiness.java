package com.akta.yelp.lambda.handlers;

import com.akta.yelp.api.YelpBusinessEndpoint;
import com.akta.yelp.api.response.ApiResult;
import com.akta.yelp.api.response.ApiResult.Visitor;
import com.akta.yelp.api.response.ErrorResult;
import com.akta.yelp.api.response.ExceptionResult;
import com.akta.yelp.models.Business;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetBusiness extends YelpBusinessEndpoint implements RequestHandler<String, Business> {

  public Business handleRequest(String businessId, Context context) {
    ApiResult<Business> apiResult = ApiResult.execute(getService().getBusiness(businessId));
    return apiResult.visit(new Visitor<Business, Business>() {
      @Override
      public Business caseSuccess(Business result) {
        return result;
      }

      @Override
      public Business caseError(ErrorResult<Business> error) {
        return null;
      }

      @Override
      public Business caseException(ExceptionResult<Business> exception) {
        return null;
      }
    });
  }

}
