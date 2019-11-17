package com.akta.yelp.api;

import com.akta.yelp.models.Business;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface YelpBusinessService {

  @GET("businesses/{id}")
  Call<Business> getBusiness(@Path("id") String businessId);
  
}
