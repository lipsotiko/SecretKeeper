package com.vango.secretkeeper.webhook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Profile("production")
public class HerokuWebhookService implements WebhookService {

  @Value("${heroku.webhook.secret}")
  private String webhookSecret;

  @Value("${heroku.webhook.events-url}")
  private String webhookEventsUrl;

  @Value("${heroku.access-token}")
  private String herokuAccessToken;

  @Override
  public void save(HerokuWebhookPayload webhookPayload) {
    log.info("Not doing anything with the webhook payload: {}", webhookPayload);
  }

  @Override
  public HerokuWebhookPayload read() {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setBearerAuth(herokuAccessToken);
    httpHeaders.add("Accept", "application/vnd.heroku+json; version=3.webhooks");
    HttpEntity<String> requestEntity = new HttpEntity<>(null, httpHeaders);
    ResponseEntity<List<HerokuWebhookEvent>> exchange =
      restTemplate.exchange(webhookEventsUrl, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {
      });
    Comparator<HerokuWebhookEvent> cmp = Comparator.comparing(HerokuWebhookEvent::getCreatedAt);
    return Objects.requireNonNull(exchange.getBody()).stream().max(cmp).orElseThrow().getPayload();
  }

  @Override
  public Boolean isValid(String secret) {
    return secret.equals(webhookSecret);
  }
}
