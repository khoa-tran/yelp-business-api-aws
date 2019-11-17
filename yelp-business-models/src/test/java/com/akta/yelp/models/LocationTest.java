package com.akta.yelp.models;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import com.akta.yelp.utils.JsonHelper;
import com.akta.yelp.utils.ObjectMapperHelper;
import javax.json.JsonObject;
import org.junit.Test;

public class LocationTest {

  @Test
  public void serializeAndDeserialize() {
    JsonObject json = JsonHelper.object()
        .add("address1", "800 N Point St")
        .add("address2", "")
        .add("address3", "")
        .add("city", "San Francisco")
        .add("zip_code", "94109")
        .add("country", "US")
        .add("state", "CA")
        .add("display_address", JsonHelper.array()
            .add("800 N Point St")
            .add("San Francisco, CA 94109"))
        .add("cross_streets", "")
        .build();
    Location location = ObjectMapperHelper.deserialize(json.toString(), Location.class);
    assertThat(location.getAddress1(), is("800 N Point St"));
    assertThat(location.getAddress2(), is(""));
    assertThat(location.getAddress3(), is(""));
    assertThat(location.getCity(), is("San Francisco"));
    assertThat(location.getZipCode(), is("94109"));
    assertThat(location.getCountry(), is("US"));
    assertThat(location.getState(), is("CA"));
    assertThat(location.getDisplayAddress(), contains("800 N Point St", "San Francisco, CA 94109"));
    assertThat(location.getCrossStreets(), is(""));

    String serialized = ObjectMapperHelper.serialize(location);
    assertThat(ObjectMapperHelper.deserialize(serialized, Location.class), is(location));
  }

}