
package org.checkers.core;

import static org.checkers.core.PieceColour.BLACK;
import static org.checkers.core.PieceColour.WHITE;

public class CheckersGameImpl implements CheckersGame {

	public static final int COLUMNS_NUMBER = 10;
	public static final int ROWS_NUMBER = 10;
	public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
	public static final String EMPTY_CELL = "It is not possible to select an empty cell";
	public static final String CELL_ALREADY_FULL = "It is not possible to drop a piece on another";
	public static final String NOT_AUTHORIZED_TO_MOVE = "It is not authorized to do this movement";

	PieceColour[][] board = new PieceColour[COLUMNS_NUMBER][ROWS_NUMBER];

	public CheckersGameImpl() {
		initBoard();
	}

	private void initBoard() {
		for (int i = 0; i < COLUMNS_NUMBER; i++) {
			if (i % 2 == 0) {
				board[i][1] = BLACK;
				board[i][3] = BLACK;
				board[i][7] = WHITE;
				board[i][9] = WHITE;
			} else {
				board[i][0] = BLACK;
				board[i][2] = BLACK;
				board[i][6] = WHITE;
				board[i][8] = WHITE;
			}
		}
	}


	@Override
	public void movePiece(PieceColour colour, int columnSelected, int rowSelected, int columnTargeted, int rowTargeted) {
		if (rowTargeted < 0 || rowTargeted >= getRowsNumber() || rowSelected < 0 || rowSelected >= getRowsNumber()) {
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
		if (columnTargeted < 0 || columnTargeted >= getColumnsNumber() || columnSelected < 0 || columnSelected >= getColumnsNumber()) {
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
		if (getCell(columnTargeted, rowTargeted) != null) {
			throw new GameException(CELL_ALREADY_FULL);
		}
		if (getCell(columnSelected, rowSelected) == null) {
			throw new GameException(EMPTY_CELL);
		}
		if (isPieceAuthorizedToMove(colour,  columnSelected,rowSelected,  columnTargeted,rowTargeted)) {
			board[columnTargeted][rowTargeted] = getCell(columnSelected, rowSelected);
			board[columnSelected][rowSelected] = null;
		} else if (isPieceAuthorizedToEat(colour,  columnSelected,rowSelected,  columnTargeted,rowTargeted)){
			board[columnTargeted][rowTargeted] = getCell(columnSelected, rowSelected);
			board[columnSelected][rowSelected] = null;
			int colToEat = 0;
			int rowToEat = 0;
			if(columnSelected - columnTargeted < 0 ){
				colToEat = columnSelected +1;
			}else{
				colToEat = columnSelected -1;
			}
			if(rowSelected - rowTargeted <0){
				rowToEat = rowSelected +1;
			}else{
				rowToEat = rowSelected -1;
			}
			if(board[colToEat][rowToEat] != null && board[colToEat][rowToEat] != colour){
				board[colToEat][rowToEat] = null;
			}else{
				throw new GameException(NOT_AUTHORIZED_TO_MOVE);
			}
		} else {
			throw new GameException(NOT_AUTHORIZED_TO_MOVE);
		}
	}

	@Override
	public PieceColour getCell(int column, int row) {
		if (row < 0 || row >= getRowsNumber()) {
			return null;
		}
		if (column < 0 || column >= getColumnsNumber()) {
			return null;
		}
		return board[column][row];
	}

	@Override
	public int getColumnsNumber() {
		return COLUMNS_NUMBER;
	}

	@Override
	public int getRowsNumber() {
		return ROWS_NUMBER;
	}

	@Override
	public PieceColour getWinner() {
		PieceColour winner = null;
		for (int i = 0; i < COLUMNS_NUMBER; i++) {
			if(getCell(i, 0) == WHITE){
				winner = getCell(i, 0);
			}
			if(getCell(i, 9) == BLACK){
				winner = getCell(i, 9);
			}
		}
		return winner;
	}

	public boolean isPieceAuthorizedToMove(PieceColour colour, int columnSelected, int rowSelected, int columnTargeted, int rowTargeted) {
		boolean authorized = false;
		
		switch (colour) {
		case BLACK:
			if (rowSelected == rowTargeted - 1 && (columnSelected == columnTargeted + 1 || columnSelected == columnTargeted - 1)) {
				authorized = true;
			}
			break;
		case WHITE:
			if (rowSelected == rowTargeted + 1 && (columnSelected == columnTargeted + 1 || columnSelected == columnTargeted - 1)) {
				authorized = true;
			}
			break;
		default:
			authorized = false;
			break;
		}
		return authorized;
	}
	
	private boolean isPieceAuthorizedToEat(PieceColour colour, int columnSelected, int rowSelected, int columnTargeted,
			int rowTargeted) {
		boolean authorized = false;
		if (Math.abs(rowSelected - rowTargeted) == 2  && Math.abs(columnSelected - columnTargeted) == 2) {
				authorized = true;
			}
		return authorized;
	}

}
