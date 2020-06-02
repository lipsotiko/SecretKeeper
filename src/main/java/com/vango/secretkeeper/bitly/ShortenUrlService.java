package com.vango.secretkeeper.bitly;

interface ShortenUrlService {
  ShortenUrlResponse create(String longUrl);
}
