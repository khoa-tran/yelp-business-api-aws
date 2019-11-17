package com.akta.yelp.api;

import static com.akta.yelp.utils.ObjectMapperHelper.jsonMapper;

import com.google.common.net.HttpHeaders;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class YelpBusinessModule extends AbstractModule {

  @Provides
  @Singleton
  public YelpBusinessService providesYelpBusinessService(
      @Named("yelp.base_url") String baseUrl,
      @Named("yelp.api_key") String apiKey) {
    OkHttpClient httpClient = new OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(chain -> {
          Request newRequest = chain.request().newBuilder()
              .addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
              .build();
          return chain.proceed(newRequest);
        })
        .build();
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(JacksonConverterFactory.create(jsonMapper()))
        .client(httpClient)
        .build()
        .create(YelpBusinessService.class);
  }

}
