package com.vango.secretkeeper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import static java.util.UUID.randomUUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cipher {
  @Id
  private String requestId;
  private String cipher;

  public void generateRequestId() {
    this.requestId = randomUUID().toString();
  }
}
