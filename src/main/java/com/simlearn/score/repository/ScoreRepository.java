package com.simlearn.score.repository;

import com.simlearn.score.entity.TestScoreEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends MongoRepository<TestScoreEntity, String> {
    List<TestScoreEntity> findByUsername(@Param("username") String username);
}