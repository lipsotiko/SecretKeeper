package com.vango.secretkeeper.webhook;

import lombok.Data;

@Data
public class HerokuData {
  private HerokuSlug slug;
  private HerokuUser user;
  private String status;
}
