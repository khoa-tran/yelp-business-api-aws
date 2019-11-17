package com.akta.yelp.api;

import static com.google.inject.name.Names.named;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

public class YelpBusinessEnvironmentModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(String.class).annotatedWith(named("yelp_base_url")).toInstance(System.getenv("yelp_base_url"));
    bind(String.class).annotatedWith(named("aws_region")).toInstance("us-west-2");
    bind(String.class).annotatedWith(named("yelp_api_key_secret_id")).toInstance("yelp/business/api_key");
  }

  @Provides
  @Singleton
  public AWSSecretsManager providesYelpBusinessService(@Named("aws_region") String region) {
    return AWSSecretsManagerClientBuilder.standard()
        .withRegion(region)
        .build();
  }

  @Provides
  @Singleton
  @Named("yelp_api_key")
  public String providesApiKey(AWSSecretsManager secretsManager, @Named("yelp_api_key_secret_id") String secretId) {
    GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
        .withSecretId(secretId);
    GetSecretValueResult getSecretValueResult = secretsManager.getSecretValue(getSecretValueRequest);
    return getSecretValueResult.getSecretString();
  }

}
