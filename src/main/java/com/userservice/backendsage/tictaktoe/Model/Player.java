package com.userservice.backendsage.tictaktoe.Model;

import com.userservice.backendsage.tictaktoe.Enums.PLAYER_TYPE;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String playerName;
    private Symbol symbol;
    private PLAYER_TYPE playerType;

    public Player(String playerName, Symbol symbol) {
        this.playerName = playerName;
        this.symbol = symbol;
        this.playerType = PLAYER_TYPE.HUMAN;
    }
}
