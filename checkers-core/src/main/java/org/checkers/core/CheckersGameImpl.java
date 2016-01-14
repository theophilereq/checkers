
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
	public static int rowPieceToMove;
	public static int columnPieceToMove;

	PieceColour[][] board = new PieceColour[ROWS_NUMBER][COLUMNS_NUMBER];

	public CheckersGameImpl() {
		initBoard();
	}

	private void initBoard() {
		for (int i = 0; i < COLUMNS_NUMBER; i++) {
			if (i % 2 == 0) {
				board[1][i] = BLACK;
				board[3][i] = BLACK;
				board[7][i] = WHITE;
				board[9][i] = WHITE;
			} else {
				board[0][i] = BLACK;
				board[2][i] = BLACK;
				board[6][i] = WHITE;
				board[8][i] = WHITE;
			}
		}
	}

	@Override
	public void selectPiece(PieceColour colour, int row, int column) {
		if (row < 0 || row >= getRowsNumber()) {
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
		if (column < 0 || column >= getColumnsNumber()) {
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
		if (getCell(row, column) == null) {
			throw new GameException(EMPTY_CELL);
		} else {
			rowPieceToMove = row;
			columnPieceToMove = column;
		}
	}

	@Override
	public void dropPiece(PieceColour colour, int row, int column) {
		if (row < 0 || row >= getRowsNumber()) {
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
		if (column < 0 || column >= getColumnsNumber()) {
			throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		}
		if (getCell(row, column) != null) {
			throw new GameException(CELL_ALREADY_FULL);
		}
		if (isPieceAuthorizedToMove(colour, row, column)) {
			board[row][column] = getCell(rowPieceToMove, columnPieceToMove);
			board[rowPieceToMove][columnPieceToMove] = null;
		} else {
			throw new GameException(NOT_AUTHORIZED_TO_MOVE);
		}
	}

	@Override
	public PieceColour getCell(int row, int column) {
		if (row < 0 || row >= getRowsNumber()) {
			return null;
		}
		if (column < 0 || column >= getColumnsNumber()) {
			return null;
		}
		return board[row][column];
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
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isPieceAuthorizedToMove(PieceColour colour, int row, int column) {
		boolean authorized = false;

		switch (colour) {
		case BLACK:
			if (rowPieceToMove == row - 1 && (columnPieceToMove == column + 1 || columnPieceToMove == column - 1)) {
				authorized = true;
			}
			break;
		case WHITE:
			if (rowPieceToMove == row + 1 && (columnPieceToMove == column + 1 || columnPieceToMove == column - 1)) {
				authorized = true;
			}
			break;
		default:
			authorized = false;
			break;
		}
		return authorized;
	}

}
