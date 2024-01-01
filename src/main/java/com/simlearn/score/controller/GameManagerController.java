package com.simlearn.score.controller;

import com.simlearn.score.dto.GameDto;
import com.simlearn.score.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class GameManagerController {

    @Autowired
    private GameService gameService;

    @PostMapping("/game")
    public void createNewGame(@RequestBody GameDto gameDto) {
        gameService.saveGame(gameDto);
    }

    @GetMapping("/game")
    public List<GameDto> findAllGames() {
        return gameService.findAllGames();
    }
}
