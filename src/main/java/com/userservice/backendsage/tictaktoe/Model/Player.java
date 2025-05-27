package com.userservice.backendsage.tictaktoe.Model;

import com.userservice.backendsage.tictaktoe.Enums.PLAYER_TYPE;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private String playerName;
    private Symbol symbol;
    private PLAYER_TYPE playerType;
    private static Scanner scanner = new Scanner(System.in);
    public Player(String playerName, Symbol symbol) {
        this.playerName = playerName;
        this.symbol = symbol;
        this.playerType = PLAYER_TYPE.HUMAN;
    }
    public Move makeMove(Board board) {
        //take input from the user
        System.out.println("Enter Row number :");
        int row=scanner.nextInt();
        System.out.println("Enter Column number :");
        int col=scanner.nextInt();

        return new Move(new Cell(row,col),this);
    }
}
