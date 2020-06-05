package com.vango.secretkeeper;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cipher")
public class SecretKeeperController {

  private final CipherService cipherService;

  public SecretKeeperController(CipherService cipherService) {
    this.cipherService = cipherService;
  }

  @PostMapping("/save")
  public String save(@RequestBody Cipher cipher) {
    cipher.generateRequestId();
    cipherService.save(cipher);
    return cipher.getRequestId();
  }

  @GetMapping("/read")
  public Cipher read(@RequestParam String requestId) {
    Optional<Cipher> optionalCipher = cipherService.get(requestId);
    if (optionalCipher.isPresent()) {
      Cipher cipher = optionalCipher.get();
      cipherService.delete(cipher);
      return cipher;
    } else {
      return null;
    }
  }
}
