package com.userservice.backendsage.tictaktoe.Controller;

import com.userservice.backendsage.tictaktoe.Enums.GAME_STATUS;
import com.userservice.backendsage.tictaktoe.Model.Game;
import com.userservice.backendsage.tictaktoe.Model.Player;

import java.util.List;

public class GameController {
    public Game StartGame(int dimentions, List<Player>player){

        return Game.getBuilder()
                .setSize(dimentions)
                .setPlayers(player)
                .Build();
    }
    public void makeMove(Game game){
        game.MakeMove();
    }
    public Player diplayName(Game game){
        return game.getWinner();
    }
    public GAME_STATUS getState(Game game){
        return game.getStatus();
    }
    public void displayBoard(Game game) {
        game.displayBoard();
    }
}
