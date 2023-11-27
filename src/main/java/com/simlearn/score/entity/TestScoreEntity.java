package com.simlearn.score.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class TestScoreEntity {
    @Id
    private String id;
    private String username;
    private String score;
    private String examType;
    private String time;
}
