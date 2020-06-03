package com.vango.secretkeeper.webhook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/webhook")
public class WebhookController {

  private final WebhookService webhookService;

  public WebhookController(WebhookService webhookService) {
    this.webhookService = webhookService;
  }

  @PostMapping("/save")
  public ResponseEntity<Object> saveHerokuReleaseWebHook(@RequestBody HerokuWebhookPayload herokuWebhookPayload, HttpServletRequest httpServletRequest) {
    String authorization = httpServletRequest.getHeader("Authorization");
    if (webhookService.isValid(authorization)) {
      log.info("Received webhook payload from Heroku");
      webhookService.save(herokuWebhookPayload);
      return ResponseEntity.noContent().build();
    } else {
      webhookService.save(null);
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/read")
  public HerokuWebhookPayload readHerokuReleaseWebHook() {
    return webhookService.read();
  }
}
