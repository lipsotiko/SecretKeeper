package com.vango.secretkeeper;

import java.util.Optional;

public interface CipherService {
  void save(Cipher cipher);

  void delete(Cipher cipher);

  Optional<Cipher> get(String requestId);
}
