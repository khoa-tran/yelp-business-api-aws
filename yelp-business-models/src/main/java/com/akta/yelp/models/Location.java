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
public class Location {

  @JsonProperty("address1")
  private String address1;

  @JsonProperty("address2")
  private String address2;

  @JsonProperty("address3")
  private String address3;

  @JsonProperty("city")
  private String city;

  @JsonProperty("zip_code")
  private String zipCode;

  @JsonProperty("country")
  private String country;

  @JsonProperty("state")
  private String state;

  @JsonProperty("display_address")
  private List<String> displayAddress;

  @JsonProperty("cross_streets")
  private String crossStreets;

}
