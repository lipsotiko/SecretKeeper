package com.vango.secretkeeper;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CipherRepository extends MongoRepository<Cipher, String> {
}
