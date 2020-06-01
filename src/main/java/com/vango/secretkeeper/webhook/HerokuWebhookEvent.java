package com.vango.secretkeeper.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HerokuWebhookEvent {
  @JsonProperty("created_at")
  private LocalDateTime createdAt;
  private HerokuWebhookPayload payload;
}
