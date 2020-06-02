package com.vango.secretkeeper.bitly;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("production")
public class BitlyShortenUrlService implements ShortenUrlService {

  @Value("${bitly.api-url}")
  private String bitlyApiUrl;

  @Value("${bitly.access-token}")
  private String bitlyAccessToken;

  @Override
  public ShortenUrlResponse create(String longUrl) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setBearerAuth(bitlyAccessToken);
    HttpEntity<ShortenUrlRequest> requestEntity = new HttpEntity<>(new ShortenUrlRequest(longUrl), httpHeaders);
    ResponseEntity<ShortenUrlResponse> exchange =
      restTemplate.exchange(bitlyApiUrl, HttpMethod.POST, requestEntity, ShortenUrlResponse.class);
    return exchange.getBody();
  }
}
