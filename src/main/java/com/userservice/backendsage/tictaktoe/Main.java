package com.userservice.backendsage.tictaktoe;

import com.userservice.backendsage.tictaktoe.Controller.GameController;
import com.userservice.backendsage.tictaktoe.Enums.BOT_DIFFICULTY_LEVEL;
import com.userservice.backendsage.tictaktoe.Enums.GAME_STATUS;
import com.userservice.backendsage.tictaktoe.Enums.PLAYER_TYPE;
import com.userservice.backendsage.tictaktoe.Model.Bot;
import com.userservice.backendsage.tictaktoe.Model.Game;
import com.userservice.backendsage.tictaktoe.Model.Player;
import com.userservice.backendsage.tictaktoe.Model.Symbol;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        GameController gameController = new GameController();

        //abstraction here -->> we are hiding all the details from details and only exposing dimentions and player arraylist
        //cleint doe't know how internally start game methord is implemented
        int size=3;
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Ayush",new Symbol('X')));
        players.add(new Bot("Computer",new Symbol('O'),BOT_DIFFICULTY_LEVEL.EASY));

        for(gameController.)
        Game game=gameController.StartGame(size,players);
        //gameController.displayBoard(game);
        while(gameController.getState(game) == GAME_STATUS.IN_PROGRESS){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }
        if(gameController.getState(game) == GAME_STATUS.END){
            System.out.println(gameController.diplayName(game)+" won the game");
        }
        if(gameController.getState(game) == GAME_STATUS.Draw){
            System.out.println("Game Draw");
        }
    }
}