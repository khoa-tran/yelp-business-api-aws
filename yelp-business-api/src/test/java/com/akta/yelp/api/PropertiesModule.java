package com.akta.yelp.api;

import static com.google.inject.name.Names.bindProperties;

import com.google.inject.AbstractModule;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesModule extends AbstractModule {

  @Override
  protected void configure() {
    Properties properties = getConfigurationProperties();
    bindProperties(binder(), properties);
  }

  private Properties getConfigurationProperties() {
    String location = "/configuration.properties";
    Properties properties = new Properties();
    try (InputStream is = getInputStreamFromPath(location)) {
      properties.load(is);
      return properties;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private InputStream getInputStreamFromPath(String location) {
    InputStream is;
    try {
      is = new FileInputStream(location);
    } catch (FileNotFoundException e) {
      is = getClass().getResourceAsStream(location);
    }
    return is;
  }

}
