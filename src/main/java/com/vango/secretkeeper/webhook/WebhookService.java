package com.vango.secretkeeper.webhook;

public interface WebhookService {
  void save(HerokuWebhookPayload herokuWebhookPayload);

  HerokuWebhookPayload read();
}
