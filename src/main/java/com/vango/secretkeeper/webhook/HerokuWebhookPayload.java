package com.vango.secretkeeper.webhook;

import lombok.Data;

@Data
public class HerokuWebhookPayload {
  private HerokuData data;
}
