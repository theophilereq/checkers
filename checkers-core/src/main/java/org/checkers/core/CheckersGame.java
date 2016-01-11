package org.checkers.core;


public interface CheckersGame {


	/**
	 * Select a piece in a cell
	 */
    void selectPiece(ChipColour colour, int raw, int column);
    
    /**
	 * Drop the selected piece in a cell
	 */
    void dropPiece(ChipColour colour, int raw, int column);

    /**
     * Returns the colour of the chip in a given cell, null if no
     * chip is present.
     */
    ChipColour getCell(int column, int row);

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
    ChipColour getWinner();
}
