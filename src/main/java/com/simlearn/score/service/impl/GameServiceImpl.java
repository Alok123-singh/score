package com.simlearn.score.service.impl;

import com.simlearn.score.dto.GameDto;
import com.simlearn.score.entity.GameEntity;
import com.simlearn.score.exception.GameAlreadyExistException;
import com.simlearn.score.service.GameService;
import io.netty.util.internal.ObjectUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveGame(GameDto gameDto) {
        GameEntity gameEntity = new GameEntity();
        gameEntity.setName(gameDto.getName());
        gameEntity.setType(gameDto.getType());
        gameEntity.setGameId(gameDto.getGameId());
        if (ObjectUtils.isNotEmpty(mongoTemplate.find(new Query(Criteria.where("gameId").is(gameDto.getGameId())), GameEntity.class))) {
            throw new GameAlreadyExistException("There is already a game with this gameId");
        }
        mongoTemplate.save(gameEntity);
    }

    @Override
    public List<GameDto> findAllGames() {
        List<GameEntity> gameEntity = mongoTemplate.findAll(GameEntity.class);
        return convertToGameDto(gameEntity);
    }

    private List<GameDto> convertToGameDto(List<GameEntity> gameEntities) {
        List<GameDto> gameDtos = new ArrayList<>();
        gameEntities.stream().forEach(gameEntity -> {
            GameDto gameDto = new GameDto();
            gameDto.setName(gameEntity.getName());
            gameDto.setType(gameEntity.getType());
            gameDto.setGameId(gameEntity.getGameId());
            gameDtos.add(gameDto);
        });
        return gameDtos;
    }
}
