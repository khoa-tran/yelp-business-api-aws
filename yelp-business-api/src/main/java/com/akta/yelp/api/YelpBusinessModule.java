package com.akta.yelp.api;

import static com.akta.yelp.utils.ObjectMapperHelper.jsonMapper;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class YelpBusinessModule extends AbstractModule {

  @Provides
  @Singleton
  public YelpBusinessService providesYelpBusinessService() {
    OkHttpClient httpClient = new OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build();
    return new Retrofit.Builder()
        .baseUrl("https://api.yelp.com/v3/")
        .addConverterFactory(JacksonConverterFactory.create(jsonMapper()))
        .client(httpClient)
        .build()
        .create(YelpBusinessService.class);
  }

}
