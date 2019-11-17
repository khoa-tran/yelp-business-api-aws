package com.akta.yelp.api;

import static com.google.inject.name.Names.named;

import com.google.inject.AbstractModule;

public class YelpBusinessEnvironmentModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(String.class).annotatedWith(named("yelp_base_url")).toInstance(System.getenv("yelp_base_url"));
    bind(String.class).annotatedWith(named("yelp_api_key")).toInstance(System.getenv("yelp_api_key"));
  }

}
