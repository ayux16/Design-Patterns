package com.userservice.backendsage.tictaktoe.Model.Factory;

import com.userservice.backendsage.tictaktoe.Enums.BOT_DIFFICULTY_LEVEL;
import com.userservice.backendsage.tictaktoe.Model.Strategy.BotWinningStrategy.BotPlayingStrategy;
import com.userservice.backendsage.tictaktoe.Model.Strategy.BotWinningStrategy.EasyBotPlayingStrategy;
import com.userservice.backendsage.tictaktoe.Model.Strategy.BotWinningStrategy.HardBotPlayingStrategy;
import com.userservice.backendsage.tictaktoe.Model.Strategy.BotWinningStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BOT_DIFFICULTY_LEVEL level) {
        if(level.equals(BOT_DIFFICULTY_LEVEL.EASY)){
            return new EasyBotPlayingStrategy();
        }
        else if(level.equals(BOT_DIFFICULTY_LEVEL.MEDIUM)){
            return new MediumBotPlayingStrategy();
        }
        else if(level.equals(BOT_DIFFICULTY_LEVEL.HARD)){
            return new HardBotPlayingStrategy();
        }
        return null;
    }
}
