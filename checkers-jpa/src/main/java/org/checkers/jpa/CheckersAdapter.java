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
			this.coreGame.selectPiece(turn.getColour(), turn.getRowSelected(), turn.getColumnSelected());
			this.coreGame.dropPiece(turn.getColour(), turn.getRowTargeted(), turn.getColumnTargeted());
		}
	}

	@Override
	public void selectPiece(PieceColour colour, int row, int column) throws GameException {
		coreGame.selectPiece(colour, row, column);
		
	}

	@Override
	public void dropPiece(PieceColour colour, int row, int column) throws GameException {
//		coreGame.dropPiece(colour, row, column);
//		this.game.getTurns().add(new Turn(this.game, colour, this.coreGame.rowPieceToMove, this.coreGame.columnPieceToMove, row, column))
		
	}

	@Override
	public PieceColour getCell(int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnsNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowsNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PieceColour getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

}
