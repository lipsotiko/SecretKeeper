package com.vango.secretkeeper.bitly;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"development", "local"})
public class DevelopmentShortenUrlService implements ShortenUrlService {

  @Override
  public ShortenUrlResponse create(String longUrl) {
    return new ShortenUrlResponse(longUrl);
  }
}
