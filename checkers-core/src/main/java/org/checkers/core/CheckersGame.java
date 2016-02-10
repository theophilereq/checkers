package org.checkers.core;

public interface CheckersGame {

    /**
	 *Select and drop a piece on the board
	 * @param colour
	 * @param rowSelected
	 * @param columnSelected
	 * @param rowTargeted
	 * @param columnTargeted
	 * @throws GameException
	 */
    void movePiece(PieceColour colour,  int columnSelected, int rowSelected, int columnTargeted, int rowTargeted) throws GameException;

    /**
     * Returns the colour of the piece in a given cell, null if no piece is present
	 * @param row
	 * @param column
     */
    PieceColour getCell(int column, int row);
    
    /**
     * Returns the number of columns
     */
    int getColumnsNumber();

    /**
     * Returns the number of rows
     */
    int getRowsNumber();

    /**
     * Returns the colour of the winner, null if no winner
     */
    PieceColour getWinner();
    
}
