package com.akta.yelp.utils;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class JsonHelper {

  public static JsonObjectBuilder object() {
    return Json.createObjectBuilder();
  }

  public static JsonArrayBuilder array() {
    return Json.createArrayBuilder();
  }

}
