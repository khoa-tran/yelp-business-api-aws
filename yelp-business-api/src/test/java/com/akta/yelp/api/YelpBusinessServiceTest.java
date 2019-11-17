package com.akta.yelp.api;

import static com.google.inject.Guice.createInjector;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.akta.yelp.api.response.ApiResult;
import com.akta.yelp.api.response.ApiResult.Visitor;
import com.akta.yelp.api.response.ErrorResult;
import com.akta.yelp.api.response.ExceptionResult;
import com.akta.yelp.models.Business;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("makes live requests - real api_key needed")
public class YelpBusinessServiceTest {

  private static Injector injector;

  @BeforeClass
  public static void beforeClass() {
    injector = createInjector(new YelpBusinessModule(), new AbstractModule() {
      @Override
      protected void configure() {
        install(new PropertiesModule());
      }
    });
  }

  @Test
  public void getBusiness() {
    YelpBusinessService service = injector.getInstance(YelpBusinessService.class);
    assertThat(ApiResult.execute(service.getBusiness("north-india-restaurant-san-francisco"))
        .visit(new Visitor<Business, Boolean>() {
          @Override
          public Boolean caseSuccess(Business result) {
            assertThat(result.getId(), is(notNullValue()));
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

}