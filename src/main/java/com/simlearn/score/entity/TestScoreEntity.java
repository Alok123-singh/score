package com.simlearn.score.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("TestScores")
public class TestScoreEntity {
    @Id
    private String _id;
    private String username;
    private String score;
    private String examType;
    private String time;
}
