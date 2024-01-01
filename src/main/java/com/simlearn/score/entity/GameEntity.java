package com.simlearn.score.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Games")
public class GameEntity {
    String _id;
    String name;
    String type;
}
