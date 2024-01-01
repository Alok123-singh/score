package com.simlearn.score.service;

import com.simlearn.score.dto.GameDto;

import java.util.List;

public interface GameService {
    void saveGame(GameDto gameDto);
    List<GameDto> findAllGames();
}
