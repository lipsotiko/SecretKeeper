package com.vango.secretkeeper;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/api/cipher")
public class SecretKeeperController {

  private final Map<String, String> ciphers;

  public SecretKeeperController() {
    ciphers = new HashMap<>();
  }

  @PostMapping("/save")
  public String save(@RequestBody SaveSecretRequest saveSecretRequest) {
    String requestGuid = randomUUID().toString();
    ciphers.put(requestGuid, saveSecretRequest.getCipherText());
    return requestGuid;
  }

  @GetMapping("/read")
  public String read(@RequestParam String requestGuid) {
    String cipherText = ciphers.get(requestGuid);
    if (cipherText != null) {
      ciphers.remove(requestGuid);
      return cipherText;
    } else {
      return null;
    }
  }
}
