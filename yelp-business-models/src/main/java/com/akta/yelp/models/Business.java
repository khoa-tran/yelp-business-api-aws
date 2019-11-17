package com.akta.yelp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Business {

  @JsonProperty("id")
  private String id;

  @JsonProperty("alias")
  private String alias;

  @JsonProperty("name")
  private String name;

  @JsonProperty("image_url")
  private String imageUrl;

  @JsonProperty("is_claimed")
  private boolean claimed;

  @JsonProperty("is_closed")
  private boolean closed;

  @JsonProperty("url")
  private String url;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("display_phone")
  private String displayPhone;

  @JsonProperty("review_count")
  private Integer reviewCount;

  @JsonProperty("categories")
  private List<Category> categories;

  @JsonProperty("rating")
  private double rating;

  @JsonProperty("location")
  private Location location;

  @JsonProperty("coordinates")
  private Coordinates coordinates;

  @JsonProperty("photos")
  private List<String> photos;

  @JsonProperty("price")
  private String price;

}
