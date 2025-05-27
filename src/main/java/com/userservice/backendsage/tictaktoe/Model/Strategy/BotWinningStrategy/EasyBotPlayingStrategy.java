package com.userservice.backendsage.tictaktoe.Model.Strategy.BotWinningStrategy;

import com.userservice.backendsage.tictaktoe.Enums.CELL_STATUS;
import com.userservice.backendsage.tictaktoe.Model.Board;
import com.userservice.backendsage.tictaktoe.Model.Cell;
import com.userservice.backendsage.tictaktoe.Model.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        //iterate tthrowgh the board and find the first empty cell on the board
        for(List<Cell>cells : board.getBoard()){
            for(Cell cell : cells){
                if(cell.getCellStatus().equals(CELL_STATUS.EMPTY)){
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }
}
