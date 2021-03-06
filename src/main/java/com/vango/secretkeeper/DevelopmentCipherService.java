package com.vango.secretkeeper;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Profile("development")
public class DevelopmentCipherService implements CipherService {

  private final Map<String, Cipher> cipherRepository;

  public DevelopmentCipherService() {
    this.cipherRepository = new HashMap<>();
  }

  @Override
  public void save(Cipher cipher) {
    cipherRepository.put(cipher.getRequestId(), cipher);
  }

  @Override
  public void delete(Cipher cipher) {
    cipherRepository.remove(cipher.getRequestId());
  }

  @Override
  public Optional<Cipher> get(String requestId) {
    Cipher cipher = cipherRepository.get(requestId);
    return Optional.of(cipher);
  }

}
