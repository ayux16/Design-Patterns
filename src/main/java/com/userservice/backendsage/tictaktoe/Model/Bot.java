package com.userservice.backendsage.tictaktoe.Model;

import com.userservice.backendsage.tictaktoe.Enums.BOT_DIFFICULTY_LEVEL;
import com.userservice.backendsage.tictaktoe.Enums.PLAYER_TYPE;
import com.userservice.backendsage.tictaktoe.Model.Factory.BotPlayingStrategyFactory;
import com.userservice.backendsage.tictaktoe.Model.Strategy.BotWinningStrategy.BotPlayingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{
    private BOT_DIFFICULTY_LEVEL botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String playerName, Symbol symbol, BOT_DIFFICULTY_LEVEL botDifficultyLevel) {
        super(playerName, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        Move move=botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
