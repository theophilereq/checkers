package org.checkers.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.checkers.core.PieceColour;

@Entity(name="Game")
public class Game {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToMany(mappedBy="game", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @OrderColumn(name="index")
    private List<Turn> turns = new ArrayList<>();

    private String currentTurn = PieceColour.WHITE.toString();

    private String gameExceptionMessage;

    public Game() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;

    }

    public List<Turn> getTurns() {
        return turns;
    }

    public PieceColour getCurrentTurn() {
        return  PieceColour.valueOf(currentTurn);
    }

    public void setCurrentTurn(PieceColour colour) {
        currentTurn = colour.toString();
    }

    public String getGameExceptionMessage() {
        return gameExceptionMessage;
    }

    public void setGameExceptionMessage(String gem) {
        gameExceptionMessage = gem;
    }
}
