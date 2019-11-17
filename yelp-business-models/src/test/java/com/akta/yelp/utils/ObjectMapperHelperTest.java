package com.akta.yelp.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.json.JsonObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

public class ObjectMapperHelperTest {

  @Test
  public void deserializeAndSerialize() {
    JsonObject json = JsonHelper.object()
        .add("string_field", "abc")
        .add("double_field", 123.45)
        .add("integer_field", 123)
        .add("is_bool", true)
        .build();
    TestData testData = ObjectMapperHelper.deserialize(json.toString(), TestData.class);
    assertThat(testData.getStringField(), is("abc"));
    assertThat(testData.getDoubleField(), is(123.45));
    assertThat(testData.getIntegerField(), is(123));
    assertThat(testData.isBool(), is(true));

    String serialized = ObjectMapperHelper.serialize(testData);
    assertThat(ObjectMapperHelper.deserialize(serialized, TestData.class), is(testData));
  }

  @EqualsAndHashCode
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @Getter
  @Builder
  private static class TestData {

    @JsonProperty("string_field")
    private String stringField;

    @JsonProperty("double_field")
    private double doubleField;

    @JsonProperty("integer_field")
    private int integerField;

    @JsonProperty("is_bool")
    private boolean bool;

  }

}