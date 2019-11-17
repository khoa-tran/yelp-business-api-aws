package com.akta.yelp.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.akta.yelp.utils.JsonHelper;
import com.akta.yelp.utils.ObjectMapperHelper;
import javax.json.JsonObject;
import org.junit.Test;

public class CoordinatesTest {

  @Test
  public void serializeAndDeserialize() {
    JsonObject json = JsonHelper.object()
        .add("latitude", 37.80587)
        .add("longitude", -122.42058)
        .build();
    Coordinates coordinates = ObjectMapperHelper.deserialize(json.toString(), Coordinates.class);
    assertThat(coordinates.getLatitude(), is(37.80587));
    assertThat(coordinates.getLongitude(), is(-122.42058));

    String serialized = ObjectMapperHelper.serialize(coordinates);
    assertThat(ObjectMapperHelper.deserialize(serialized, Coordinates.class), is(coordinates));
  }

}