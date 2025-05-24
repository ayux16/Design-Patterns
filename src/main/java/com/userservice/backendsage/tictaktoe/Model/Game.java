package com.userservice.backendsage.tictaktoe.Model;

import com.userservice.backendsage.tictaktoe.Enums.GAME_STATUS;
import com.userservice.backendsage.tictaktoe.Enums.PLAYER_TYPE;
import com.userservice.backendsage.tictaktoe.Exceptions.InvalidPlayerCountException;
import com.userservice.backendsage.tictaktoe.Exceptions.InvalidPlayerSymbol;
import com.userservice.backendsage.tictaktoe.Exceptions.invalidBotCountException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move>moves;
    private GAME_STATUS status;
    private String winner;
    private int nextPlayerIndex;

    public Game(int size,List<Player> players){
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.status = GAME_STATUS.IN_PROGRESS;
        this.nextPlayerIndex=0;
    }

    public void displayBoard(){
        this.board.displayBoard();
    }
    public static Builder getBuilder() {
        return new Builder();
    }
    public static class Builder{
        private int size;
        private List<Player> players;

        public int getSize() {
            return size;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        private void validateBotCount(){
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PLAYER_TYPE.BOT)){
                    botCount++;
                }
            }
            if(botCount >1){
                throw new invalidBotCountException("Bot cannot be more than one time");
            }
        }
        private void validatePlayerCount(){
            int playerCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PLAYER_TYPE.HUMAN)){
                    playerCount++;
                }
            }
            if(playerCount >size-1){
                throw new InvalidPlayerCountException("Player cannot be more than size of game");
            }
        }
        private void validatePlayerSymbol(){
            Set<Character> symbols = new HashSet<>();
            for(Player player : players){
                char symbol=player.getSymbol().getCh();
                if(symbols.contains(symbol)){
                    throw new InvalidPlayerSymbol("No two Player Can have same symbol");
                }
                symbols.add(symbol);
            }
        }
        private void validations(){
            validateBotCount();
            validatePlayerCount();
            validatePlayerSymbol();
        }
        public Game Build(){
            validations();
            return new Game(size,players);
        }
    }
}
