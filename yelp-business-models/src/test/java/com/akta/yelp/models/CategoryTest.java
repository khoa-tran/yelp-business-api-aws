package com.akta.yelp.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.akta.yelp.utils.JsonHelper;
import com.akta.yelp.utils.ObjectMapperHelper;
import javax.json.JsonObject;
import org.junit.Test;

public class CategoryTest {

  @Test
  public void serializeAndDeserialize() {
    JsonObject json = JsonHelper.object()
        .add("alias", "wine_bars")
        .add("title", "Wine Bars")
        .build();
    Category category = ObjectMapperHelper.deserialize(json.toString(), Category.class);
    assertThat(category.getAlias(), is("wine_bars"));
    assertThat(category.getTitle(), is("Wine Bars"));

    String serialized = ObjectMapperHelper.serialize(category);
    assertThat(ObjectMapperHelper.deserialize(serialized, Category.class), is(category));
  }

}