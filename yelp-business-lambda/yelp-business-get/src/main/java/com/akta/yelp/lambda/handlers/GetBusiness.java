package com.akta.yelp.lambda.handlers;

import com.akta.yelp.api.YelpBusinessService;
import com.akta.yelp.api.response.ApiResult;
import com.akta.yelp.models.Business;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.inject.Inject;

public class GetBusiness implements RequestHandler<String, ApiResult<Business>> {

  @Inject
  YelpBusinessService service;

  public ApiResult<Business> handleRequest(String businessId, Context context) {
    return ApiResult.execute(service.getBusiness(businessId));
  }

}
