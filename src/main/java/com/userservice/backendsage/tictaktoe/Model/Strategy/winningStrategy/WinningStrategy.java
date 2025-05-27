package com.userservice.backendsage.tictaktoe.Model.Strategy.winningStrategy;

import com.userservice.backendsage.tictaktoe.Model.Board;
import com.userservice.backendsage.tictaktoe.Model.Move;

public interface WinningStrategy {
    boolean checkWinner(Move move, Board board);
}
