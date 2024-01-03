package com.simlearn.score.service.impl;

import com.simlearn.score.dto.TestScoreDto;
import com.simlearn.score.entity.TestScoreEntity;
import com.simlearn.score.repository.ScoreRepository;
import com.simlearn.score.service.ScoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public void saveScore(TestScoreDto testScoreDto) {
        TestScoreEntity testScoreEntity = new TestScoreEntity();
        BeanUtils.copyProperties(testScoreDto, testScoreEntity);
        testScoreEntity.setTime(LocalDateTime.now().toString());
        scoreRepository.save(testScoreEntity);
    }

    @Override
    public List<TestScoreDto> findScoreForStudent(String email) {
        List<TestScoreEntity> testScoreEntityList = scoreRepository.findByEmail(email);
        return createTestScoreDtoList(testScoreEntityList);
    }

    @Override
    public List<TestScoreDto> findScoreForCourse(String courseCode) {
        List<TestScoreEntity> testScoreEntityList = scoreRepository.findByCourseCode(courseCode);
        return createTestScoreDtoList(testScoreEntityList);
    }

    private List<TestScoreDto> createTestScoreDtoList(List<TestScoreEntity> testScoreEntityList) {
        List<TestScoreDto> scoreDtoList = new ArrayList<>();
        testScoreEntityList.stream().forEach(testScoreEntity -> {
            TestScoreDto testScoreDto = new TestScoreDto();
            BeanUtils.copyProperties(testScoreEntity, testScoreDto);
            scoreDtoList.add(testScoreDto);
        });
        return scoreDtoList;
    }
}