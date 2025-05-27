package com.userservice.backendsage.tictaktoe.Model.Strategy.BotWinningStrategy;

import com.userservice.backendsage.tictaktoe.Model.Board;
import com.userservice.backendsage.tictaktoe.Model.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
