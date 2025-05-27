package com.userservice.backendsage.tictaktoe.Model;

import com.userservice.backendsage.tictaktoe.Enums.CELL_STATUS;
import com.userservice.backendsage.tictaktoe.Enums.GAME_STATUS;
import com.userservice.backendsage.tictaktoe.Enums.PLAYER_TYPE;
import com.userservice.backendsage.tictaktoe.Exceptions.InvalidPlayerCountException;
import com.userservice.backendsage.tictaktoe.Exceptions.InvalidPlayerSymbol;
import com.userservice.backendsage.tictaktoe.Exceptions.illegalMoveException;
import com.userservice.backendsage.tictaktoe.Exceptions.invalidBotCountException;
import com.userservice.backendsage.tictaktoe.Model.Strategy.winningStrategy.ColumnWinningStrategy;
import com.userservice.backendsage.tictaktoe.Model.Strategy.winningStrategy.DiagonalWinningStrategy;
import com.userservice.backendsage.tictaktoe.Model.Strategy.winningStrategy.RowWinningStrategy;
import com.userservice.backendsage.tictaktoe.Model.Strategy.winningStrategy.WinningStrategy;
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
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategy>winningStrategies;

    private boolean validateMove(Move move,Board board) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        if(row<0 ||
                row>= this.board.getSize() ||
                col<0 ||
                col>= this.board.getSize()){
            return false;
        }
        return board.getBoard().get(row).get(col).isEmpty();

    }
    public Game(int size,List<Player> players,List<WinningStrategy> winningStrategies){
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.status = GAME_STATUS.IN_PROGRESS;
        this.nextPlayerIndex=0;
        this.winningStrategies = winningStrategies;
    }
    public void MakeMove(){
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("this is " + currentPlayer.getPlayerName() +"'s move");
        //player wants to make a move at this row and column
        Move move=currentPlayer.makeMove(board);
        //check if user is making valid move or not
        if(!validateMove(move,board)){
            throw new illegalMoveException("Invalid move we cannot make a move");
        }
        //make move if valid move at row and column
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        //get that particular cell from that matrix
        Cell cell=board.getBoard().get(row).get(col);
        //change the status
        cell.setCellStatus(CELL_STATUS.FILLED);
        cell.setPlayer(currentPlayer);

        System.out.println(currentPlayer.getPlayerName()+" have made a move");
        //for coorect player incex
        //increment the index
        nextPlayerIndex=(nextPlayerIndex+1)%players.size();

        //make move OBJ at that that this player is making move at this cell
        Move finalMove=new Move(cell,currentPlayer);

        //add move in list of moves;
        moves.add(finalMove);

        //move and Final Move
        // move one is creating player object which will make the move
        //final move is creating an obj of cell at whiich the player will amek a move

        //check winner at each stage
        if(checkWinner(finalMove,board)){
            status=GAME_STATUS.END;
            winner=currentPlayer;
        }
        else if(moves.size()==board.getSize()*board.getSize()){
            status=GAME_STATUS.Draw;

        }
    }
    public boolean checkWinner(Move move,Board board){
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWinner(move, board)) {
                return true;
            }
            break;

        }
        return false;
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
            List<WinningStrategy> winningStrategies = new ArrayList<>();
            winningStrategies.add(new RowWinningStrategy());
            winningStrategies.add(new ColumnWinningStrategy());
            winningStrategies.add(new DiagonalWinningStrategy());
            return new Game(size,players,winningStrategies);
        }
    }
}
