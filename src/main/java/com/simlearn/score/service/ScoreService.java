package com.simlearn.score.service;

import com.simlearn.score.dto.TestScoreDto;
import com.simlearn.score.entity.TestScoreEntity;

import java.util.List;

public interface ScoreService {
    void saveScore(TestScoreDto testScoreDto);
    List<TestScoreDto> findScoreForStudent(String username);
    List<TestScoreDto> findScoreForCourse(String courseCode);
}
