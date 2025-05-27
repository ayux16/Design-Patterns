package com.userservice.backendsage.tictaktoe.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            board.add(new ArrayList<>());
            for(int j = 0; j < size; j++) {
                board.get(i).add(new Cell(i,j));
            }
        }
    }
    public void displayBoard() {
        for(List<Cell> cells : board) {
            for(Cell cell : cells) {
                if(cell.isEmpty()){
                    System.out.print("| |");
                }
                else{
                    System.out.print("| "+cell.getPlayer().getSymbol().getCh()+" |");
                }
            }
            System.out.println();
        }
    }
}
