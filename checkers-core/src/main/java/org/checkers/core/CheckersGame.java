package org.checkers.core;


public interface CheckersGame {


	/**
	 * Select a piece in a cell
	 */
    void selectPiece(PieceColour colour, int raw, int column);
    
    /**
	 * Drop the selected piece in a cell
	 */
    void dropPiece(PieceColour colour, int raw, int column);

    /**
     * Returns the colour of the chip in a given cell, null if no
     * chip is present.
     */
    PieceColour getCell(int column, int row);

    /**
     * Returns the number of columns.
     */
    int getColumnsNumber();

    /**
     * Returns the number of rows.
     */
    int getRowsNumber();

    /**
     * Returns the colour of the winner, null if no winner.
     */
    PieceColour getWinner();
}
