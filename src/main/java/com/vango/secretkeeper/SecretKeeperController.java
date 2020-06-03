package com.vango.secretkeeper;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/api/cipher")
public class SecretKeeperController {

  private final CipherService cipherService;

  public SecretKeeperController(CipherService cipherService) {
    this.cipherService = cipherService;
  }

  @PostMapping("/save")
  public String save(@RequestBody SaveSecretRequest saveSecretRequest) {
    String requestId = randomUUID().toString();
    cipherService.save(new Cipher(requestId, saveSecretRequest.getCipherText()));
    return requestId;
  }

  @GetMapping("/read")
  public String read(@RequestParam String requestId) {
    Optional<Cipher> optionalCipher = cipherService.get(requestId);
    if (optionalCipher.isPresent()) {
      Cipher cipher = optionalCipher.get();
      cipherService.delete(cipher);
      return cipher.getCipherText();
    } else {
      return null;
    }
  }
}
