package com.vango.secretkeeper.webhook;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"development", "local"})
public class DevelopmentWebhookService implements WebhookService {
  @Override
  public void save(HerokuWebhookPayload herokuWebhookPayload) {

  }

  @Override
  public HerokuWebhookPayload read() {
    HerokuWebhookPayload herokuWebhookPayload = new HerokuWebhookPayload();
    HerokuData data = new HerokuData();
    data.setStatus("awesome");

    HerokuSlug slug = new HerokuSlug();
    slug.setCommit("abcdefghijklmnopqrstuvwxyz");
    data.setSlug(slug);

    HerokuUser user = new HerokuUser();
    user.setEmail("vango@cool.io");
    data.setUser(user);

    herokuWebhookPayload.setData(data);
    return herokuWebhookPayload;
  }

  @Override
  public Boolean isValid(String secret) {
    return true;
  }
}
