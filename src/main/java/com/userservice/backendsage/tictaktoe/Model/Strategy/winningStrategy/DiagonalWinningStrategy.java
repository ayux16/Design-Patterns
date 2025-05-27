package com.userservice.backendsage.tictaktoe.Model.Strategy.winningStrategy;

import com.userservice.backendsage.tictaktoe.Model.Board;
import com.userservice.backendsage.tictaktoe.Model.Move;
import com.userservice.backendsage.tictaktoe.Model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    private Map<Symbol,Integer> leftDiagMap=new HashMap<>();
    private Map<Symbol,Integer> rightDiagMap=new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();
        if(row==col){
//            leftDiagMap.put(symbol,leftDiagMap.getOrDefault(symbol,1)+1);
            if(!leftDiagMap.containsKey(symbol)){
                leftDiagMap.put(symbol,0);
            }
            leftDiagMap.put(symbol,leftDiagMap.get(symbol)+1);
            return leftDiagMap.get(symbol)==board.getSize();
        }
        else if(row+col==board.getSize()-1){
//            rightDiagMap.put(symbol,rightDiagMap.getOrDefault(symbol,1)+1);
            if(!rightDiagMap.containsKey(symbol)){
                rightDiagMap.put(symbol,0);
            }
            rightDiagMap.put(symbol,rightDiagMap.get(symbol)+1);
            return rightDiagMap.get(symbol)==board.getSize();
        }
        return false;
    }
}
