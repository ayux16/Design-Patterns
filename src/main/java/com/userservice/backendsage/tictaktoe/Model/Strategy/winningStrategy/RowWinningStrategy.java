package com.userservice.backendsage.tictaktoe.Model.Strategy.winningStrategy;

import com.userservice.backendsage.tictaktoe.Model.Board;
import com.userservice.backendsage.tictaktoe.Model.Move;
import com.userservice.backendsage.tictaktoe.Model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    private Map<Integer,Map<Symbol,Integer>> rowMap=new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();

        if(!rowMap.containsKey(row)){
            rowMap.put(row,new HashMap<>());
        }
        Map<Symbol,Integer> currentRow=new HashMap<>();
        //currentRow.put(symbol,currentRow.getOrDefault(symbol,1)+1);
        if(!currentRow.containsKey(symbol)){
            currentRow.put(symbol,0);
        }
        currentRow.put(symbol,currentRow.get(symbol)+1);
        return currentRow.get(symbol)==board.getSize();
    }
}
