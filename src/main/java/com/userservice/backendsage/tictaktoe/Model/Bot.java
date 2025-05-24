package com.userservice.backendsage.tictaktoe.Model;

import com.userservice.backendsage.tictaktoe.Enums.BOT_DIFFICULTY_LEVEL;
import com.userservice.backendsage.tictaktoe.Enums.PLAYER_TYPE;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{
    private BOT_DIFFICULTY_LEVEL botDifficultyLevel;

    public Bot(String playerName, Symbol symbol, BOT_DIFFICULTY_LEVEL botDifficultyLevel) {
        super(playerName, symbol);
    }
}
