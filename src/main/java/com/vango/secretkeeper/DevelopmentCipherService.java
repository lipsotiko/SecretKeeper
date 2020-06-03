package com.vango.secretkeeper;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Profile("development")
public class DevelopmentCipherService implements CipherService {

  private final Map<String, String> cipherRepository;

  public DevelopmentCipherService() {
    this.cipherRepository = new HashMap<>();
  }

  @Override
  public void save(Cipher cipher) {
    cipherRepository.put(cipher.getRequestId(), cipher.getCipherText());
  }

  @Override
  public void delete(Cipher cipher) {
    cipherRepository.remove(cipher.getRequestId());
  }

  @Override
  public Optional<Cipher> get(String requestId) {
    String cipherText = cipherRepository.get(requestId);
    return Optional.of(new Cipher(requestId, cipherText));
  }

}
