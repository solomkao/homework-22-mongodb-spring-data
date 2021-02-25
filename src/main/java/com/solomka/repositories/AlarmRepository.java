package com.solomka.repositories;

import com.solomka.models.Alarm;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface AlarmRepository extends MongoRepository<Alarm, BigInteger> {
}
