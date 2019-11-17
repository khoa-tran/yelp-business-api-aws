package com.akta.yelp.lambda.handlers;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.name.Names.named;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.akta.yelp.api.YelpBusinessService;
import com.akta.yelp.api.response.ApiResult;
import com.akta.yelp.api.response.ApiResult.Visitor;
import com.akta.yelp.api.response.ErrorResult;
import com.akta.yelp.api.response.ExceptionResult;
import com.akta.yelp.models.Business;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Stage;
import org.junit.Test;
import retrofit2.mock.Calls;

public class GetBusinessTest {

  private final YelpBusinessService service = mock(YelpBusinessService.class);

  @Test
  public void handleRequest() {
    when(service.getBusiness("north-india-restaurant-san-francisco"))
        .thenReturn(Calls.response(
            Business.builder()
                .id("gR9DTbKCvezQlqvD7_FzPw")
                .name("North India Restaurant")
                .alias("north-india-restaurant-san-francisco")
                .build()));
    ApiResult<Business> result = getHandler().handleRequest("north-india-restaurant-san-francisco", null);
    assertThat(result.visit(new Visitor<Business, Boolean>() {
      @Override
      public Boolean caseSuccess(Business result) {
        assertThat(result.getId(), is("gR9DTbKCvezQlqvD7_FzPw"));
        assertThat(result.getName(), is("North India Restaurant"));
        assertThat(result.getAlias(), is("north-india-restaurant-san-francisco"));
        return true;
      }

      @Override
      public Boolean caseError(ErrorResult<Business> error) {
        return false;
      }

      @Override
      public Boolean caseException(ExceptionResult<Business> exception) {
        return false;
      }
    }), is(true));

  }

  private GetBusiness getHandler() {
    return new GetBusiness() {
      @Override
      public YelpBusinessService getService() {
        return service;
      }

      @Override
      protected Injector getInjector() {
        return createInjector(Stage.DEVELOPMENT, new AbstractModule() {
          @Override
          protected void configure() {
            bind(String.class).annotatedWith(named("yelp_base_url")).toInstance("");
            bind(String.class).annotatedWith(named("yelp_api_key")).toInstance("");
            bind(YelpBusinessService.class).toInstance(service);
          }
        });
      }
    };
  }

}