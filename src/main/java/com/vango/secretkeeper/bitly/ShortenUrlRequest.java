package com.vango.secretkeeper.bitly;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShortenUrlRequest {
  @JsonProperty("long_url")
  private String longUrl;
}
