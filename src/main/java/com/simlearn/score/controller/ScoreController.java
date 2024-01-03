package com.simlearn.score.controller;

import com.simlearn.score.dto.TestScoreDto;
import com.simlearn.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/score")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveScore(@RequestBody TestScoreDto testScoreDto) {
        scoreService.saveScore(testScoreDto);
    }

    @GetMapping("/score/find/{email}")
    public List<TestScoreDto> getAllTestScoreForStudent(@PathVariable String email) {
        return scoreService.findScoreForStudent(email);
    }

    //public List<TestScoreDto> getAllStudentsScore() {}
}
