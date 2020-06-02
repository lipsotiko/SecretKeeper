package com.vango.secretkeeper.webhook;

interface WebhookService {
  void save(HerokuWebhookPayload herokuWebhookPayload);

  HerokuWebhookPayload read();
}
