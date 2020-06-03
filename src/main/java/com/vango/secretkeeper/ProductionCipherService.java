package com.vango.secretkeeper;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile({"production", "local"})
public class ProductionCipherService implements CipherService {

  private final CipherRepository cipherRepository;

  public ProductionCipherService(CipherRepository cipherRepository) {
    this.cipherRepository = cipherRepository;
  }

  @Override
  public void save(Cipher cipher) {
    cipherRepository.save(cipher);
  }

  @Override
  public void delete(Cipher cipher) {
    cipherRepository.delete(cipher);
  }

  @Override
  public Optional<Cipher> get(String requestId) {
    return cipherRepository.findById(requestId);
  }
}
