package com.userservice.backendsage.tictaktoe.Model;

import com.userservice.backendsage.tictaktoe.Enums.CELL_STATUS;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int col;
    private CELL_STATUS cellStatus;
    private Player player;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.cellStatus = CELL_STATUS.EMPTY;
    }

    public Boolean isEmpty(){
        return cellStatus == CELL_STATUS.EMPTY;
    }
}
