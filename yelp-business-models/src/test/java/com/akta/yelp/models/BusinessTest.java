package com.akta.yelp.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.akta.yelp.utils.ObjectMapperHelper;
import org.junit.Test;

public class BusinessTest {

  @Test
  public void serialize() {
    String json = "{\n"
        + "  \"id\": \"WavvLdfdP6g8aZTtbBQHTw\",\n"
        + "  \"alias\": \"gary-danko-san-francisco\",\n"
        + "  \"name\": \"Gary Danko\",\n"
        + "  \"image_url\": \"https://s3-media2.fl.yelpcdn.com/bphoto/CPc91bGzKBe95aM5edjhhQ/o.jpg\",\n"
        + "  \"is_claimed\": true,\n"
        + "  \"is_closed\": false,\n"
        + "  \"url\": \"https://www.yelp.com/biz/gary-danko-san-francisco?adjust_creative=wpr6gw4FnptTrk1CeT8POg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=wpr6gw4FnptTrk1CeT8POg\",\n"
        + "  \"phone\": \"+14157492060\",\n"
        + "  \"display_phone\": \"(415) 749-2060\",\n"
        + "  \"review_count\": 5296,\n"
        + "  \"categories\": [\n"
        + "    {\n"
        + "      \"alias\": \"newamerican\",\n"
        + "      \"title\": \"American (New)\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"alias\": \"french\",\n"
        + "      \"title\": \"French\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"alias\": \"wine_bars\",\n"
        + "      \"title\": \"Wine Bars\"\n"
        + "    }\n"
        + "  ],\n"
        + "  \"rating\": 4.5,\n"
        + "  \"location\": {\n"
        + "    \"address1\": \"800 N Point St\",\n"
        + "    \"address2\": \"\",\n"
        + "    \"address3\": \"\",\n"
        + "    \"city\": \"San Francisco\",\n"
        + "    \"zip_code\": \"94109\",\n"
        + "    \"country\": \"US\",\n"
        + "    \"state\": \"CA\",\n"
        + "    \"display_address\": [\n"
        + "      \"800 N Point St\",\n"
        + "      \"San Francisco, CA 94109\"\n"
        + "    ],\n"
        + "    \"cross_streets\": \"\"\n"
        + "  },\n"
        + "  \"coordinates\": {\n"
        + "    \"latitude\": 37.80587,\n"
        + "    \"longitude\": -122.42058\n"
        + "  },\n"
        + "  \"photos\": [\n"
        + "    \"https://s3-media2.fl.yelpcdn.com/bphoto/CPc91bGzKBe95aM5edjhhQ/o.jpg\",\n"
        + "    \"https://s3-media4.fl.yelpcdn.com/bphoto/FmXn6cYO1Mm03UNO5cbOqw/o.jpg\",\n"
        + "    \"https://s3-media4.fl.yelpcdn.com/bphoto/HZVDyYaghwPl2kVbvHuHjA/o.jpg\"\n"
        + "  ],\n"
        + "  \"price\": \"$$$$\",\n"
        + "  \"hours\": [\n"
        + "    {\n"
        + "      \"open\": [\n"
        + "        {\n"
        + "          \"is_overnight\": false,\n"
        + "          \"start\": \"1730\",\n"
        + "          \"end\": \"2200\",\n"
        + "          \"day\": 0\n"
        + "        },\n"
        + "        {\n"
        + "          \"is_overnight\": false,\n"
        + "          \"start\": \"1730\",\n"
        + "          \"end\": \"2200\",\n"
        + "          \"day\": 1\n"
        + "        },\n"
        + "        {\n"
        + "          \"is_overnight\": false,\n"
        + "          \"start\": \"1730\",\n"
        + "          \"end\": \"2200\",\n"
        + "          \"day\": 2\n"
        + "        },\n"
        + "        {\n"
        + "          \"is_overnight\": false,\n"
        + "          \"start\": \"1730\",\n"
        + "          \"end\": \"2200\",\n"
        + "          \"day\": 3\n"
        + "        },\n"
        + "        {\n"
        + "          \"is_overnight\": false,\n"
        + "          \"start\": \"1730\",\n"
        + "          \"end\": \"2200\",\n"
        + "          \"day\": 4\n"
        + "        },\n"
        + "        {\n"
        + "          \"is_overnight\": false,\n"
        + "          \"start\": \"1730\",\n"
        + "          \"end\": \"2200\",\n"
        + "          \"day\": 5\n"
        + "        },\n"
        + "        {\n"
        + "          \"is_overnight\": false,\n"
        + "          \"start\": \"1730\",\n"
        + "          \"end\": \"2200\",\n"
        + "          \"day\": 6\n"
        + "        }\n"
        + "      ],\n"
        + "      \"hours_type\": \"REGULAR\",\n"
        + "      \"is_open_now\": false\n"
        + "    }\n"
        + "  ],\n"
        + "  \"transactions\": [],\n"
        + "  \"special_hours\": [\n"
        + "    {\n"
        + "      \"date\": \"2019-02-07\",\n"
        + "      \"is_closed\": null,\n"
        + "      \"start\": \"1600\",\n"
        + "      \"end\": \"2000\",\n"
        + "      \"is_overnight\": false\n"
        + "    }\n"
        + "  ]\n"
        + "}";
    Business business = ObjectMapperHelper.deserialize(json, Business.class);
    assertThat(business.getId(), is("WavvLdfdP6g8aZTtbBQHTw"));
    assertThat(business.getName(), is("Gary Danko"));
    assertThat(business.getAlias(), is("gary-danko-san-francisco"));

    String serialized = ObjectMapperHelper.serialize(business);
    assertThat(ObjectMapperHelper.deserialize(serialized, Business.class), is(business));
  }

  @Test
  public void deserialize() {

  }

}