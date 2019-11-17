package com.akta.yelp.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ObjectMapperHelper {

  private static final ObjectMapper JSON_MAPPER = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  private static final ObjectReader JSON_READER = JSON_MAPPER.reader();
  private static final ObjectWriter JSON_WRITER = JSON_MAPPER.writer();

  public static <T> T deserialize(String json, Class<T> type) {
    try {
      return JSON_READER.forType(type).readValue(json);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> String serialize(T object) {
    try {
      return JSON_WRITER.writeValueAsString(object);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
