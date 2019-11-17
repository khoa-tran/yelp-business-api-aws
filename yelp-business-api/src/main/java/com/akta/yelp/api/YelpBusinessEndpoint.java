package com.akta.yelp.api;

import static com.google.inject.Guice.createInjector;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Stage;

public abstract class YelpBusinessEndpoint {

  public YelpBusinessEndpoint() {
    Injector injector = getInjector();
    injector.injectMembers(this);
  }

  @Inject
  YelpBusinessService service;

  public YelpBusinessService getService() {
    return service;
  }

  protected Injector getInjector() {
    return createInjector(Stage.DEVELOPMENT, new YelpBusinessEnvironmentModule(), new YelpBusinessModule());
  }

}
