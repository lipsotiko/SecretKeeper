package com.vango.secretkeeper.bitly;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url")
public class ShortenUrlController {

  private final ShortenUrlService shortenUrlService;

  public ShortenUrlController(ShortenUrlService shortenUrlService) {
    this.shortenUrlService = shortenUrlService;
  }

  @GetMapping("/shorten")
  public ShortenUrlResponse createShortUrl(@RequestParam String longUrl) {
    return shortenUrlService.create(longUrl);
  }

}
