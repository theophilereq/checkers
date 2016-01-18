package org.checkers.core;

public interface CheckersGame {
    
    /**
	 * Drop the selected piece in a cell
	 * @param colour
	 * @param row
	 * @param column
	 * @throws GameException if the cell is already full or it's not allowed to drop in that cell
	 */
    void movePiece(PieceColour colour, int rowSelected, int columnSelected, int rowTargeted, int columnTargeted) throws GameException;

    /**
     * Returns the colour of the piece in a given cell, null if no piece is present
	 * @param row
	 * @param column
     */
    PieceColour getCell(int row, int column);
    
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
