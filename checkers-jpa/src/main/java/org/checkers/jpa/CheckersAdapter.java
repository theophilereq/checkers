package org.checkers.jpa;

import org.checkers.core.CheckersGame;
import org.checkers.core.CheckersGameImpl;
import org.checkers.core.GameException;
import org.checkers.core.PieceColour;

public class CheckersAdapter implements CheckersGame{
	
	private Game game;
	
	private CheckersGame coreGame;
	
	private CheckersDAO dao;
	
	public CheckersAdapter(CheckersDAO dao, Game game){
		this.dao = dao;
		this.game = game;
		this.coreGame = new CheckersGameImpl();
		
		for (Turn turn : game.getTurns()){
			this.coreGame.movePiece(turn.getColour(), turn.getColumnSelected(), turn.getRowSelected(), turn.getColumnTargeted(), turn.getRowTargeted());
		}
	}

	@Override
	public void movePiece(PieceColour colour, int columnSelected, int rowSelected, int columnTargeted, int rowTargeted) throws GameException {
		try {
			coreGame.movePiece(colour, columnSelected, rowSelected, columnTargeted, rowTargeted);
			this.game.getTurns().add(new Turn(this.game, colour, columnSelected, rowSelected, columnTargeted, rowTargeted));
			switchTurn();
			setGameExceptionMessage(null);
		} catch (GameException e) {
			setGameExceptionMessage(e.getMessage());
		}

		dao.save(game);
	}

	public void switchTurn() {
		game.setCurrentTurn(game.getCurrentTurn() == PieceColour.BLACK ? PieceColour.WHITE
				: PieceColour.BLACK);
	}

	@Override
	public PieceColour getCell(int column, int row) {
		return coreGame.getCell(column, row);
	}

	@Override
	public int getColumnsNumber() {
		return coreGame.getColumnsNumber();
	}

	@Override
	public int getRowsNumber() {
		return coreGame.getRowsNumber();
	}

	@Override
	public PieceColour getWinner() {
		return coreGame.getWinner();
	}
	
    public String getToken() {
        return game.getToken();
    }

	public PieceColour getCurrentTurn() {
		return game.getCurrentTurn();
	}

	public void setGameExceptionMessage(String gem) {
		game.setGameExceptionMessage(gem);
	}

	public String getGameExceptionMessage(){ return game.getGameExceptionMessage(); }

}