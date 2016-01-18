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
			this.coreGame.movePiece(turn.getColour(), turn.getRowSelected(), turn.getColumnSelected(), turn.getRowTargeted(), turn.getColumnTargeted());
		}
	}

	@Override
	public void movePiece(PieceColour colour, int rowSelected, int columnSelected, int rowTargeted, int columnTargeted) throws GameException {
		coreGame.movePiece(colour, rowSelected, columnSelected, rowTargeted, columnTargeted);
		this.game.getTurns().add(new Turn(this.game, colour, rowSelected, columnSelected, rowTargeted, columnTargeted));
		switchTurn();

		//dao.save(game);
	}

	public void switchTurn() {
		game.setCurrentTurn(game.getCurrentTurn() == PieceColour.BLACK ? PieceColour.WHITE
				: PieceColour.BLACK);
	}

	@Override
	public PieceColour getCell(int row, int column) {
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
		// TODO Auto-generated method stub
		return null;
	}

}
