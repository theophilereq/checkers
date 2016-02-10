package org.checkers.web;

import org.checkers.core.CheckersGame;
import org.checkers.jpa.CheckersAdapter;
import org.checkers.jpa.CheckersDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by isen on 28/01/2016.
 */
@Named("game")
@RequestScoped
public class CheckersBean  implements Serializable {

    CheckersAdapter game ;

    @Inject
    CheckersDAO dao;

    public List<CheckersColumn> getColumns() {

        List<CheckersColumn> cols = new ArrayList<>();
        for (int i = 0; i < game.getColumnsNumber(); i++) {
            cols.add(new CheckersColumn(i, game));
        }
        return cols;

    }

    public void movePiece( int columnSelected, int rowSelected, int columnTargeted, int rowTargeted) {
        game.movePiece(game.getCurrentTurn(), columnSelected, rowSelected, columnTargeted, rowTargeted);

    }

    public CheckersGame getGame() {
        return game;
    }


    public void createNewGame() {
        game = dao.createNewGame();

    }

	public String getToken() {
		return game.getToken();
	}

	public void loadFromToken(String token) {
		game = dao.loadFromToken(token);
		
	}


}
