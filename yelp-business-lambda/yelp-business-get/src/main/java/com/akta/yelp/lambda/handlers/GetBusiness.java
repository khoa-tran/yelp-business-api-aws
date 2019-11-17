package com.akta.yelp.lambda.handlers;

import com.akta.yelp.api.YelpBusinessEndpoint;
import com.akta.yelp.api.response.ApiResult;
import com.akta.yelp.models.Business;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetBusiness extends YelpBusinessEndpoint implements RequestHandler<String, ApiResult<Business>> {

  public ApiResult<Business> handleRequest(String businessId, Context context) {
    return ApiResult.execute(getService().getBusiness(businessId));
  }

}
