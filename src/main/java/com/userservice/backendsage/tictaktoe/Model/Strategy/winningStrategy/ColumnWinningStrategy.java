package com.userservice.backendsage.tictaktoe.Model.Strategy.winningStrategy;

import com.userservice.backendsage.tictaktoe.Model.Board;
import com.userservice.backendsage.tictaktoe.Model.Move;
import com.userservice.backendsage.tictaktoe.Model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{
    private Map<Integer,Map<Symbol,Integer>> columnMap=new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();

        if(!columnMap.containsKey(col)){
            columnMap.put(col,new HashMap<>());
        }
        Map<Symbol,Integer> currentColumn=new HashMap<>();
//        currentColumn.put(symbol,currentColumn.getOrDefault(symbol,1)+1);
        if(!currentColumn.containsKey(symbol)){
            currentColumn.put(symbol,0);
        }
        currentColumn.put(symbol,currentColumn.get(symbol)+1);
        return currentColumn.get(symbol)==board.getSize();
    }
}
