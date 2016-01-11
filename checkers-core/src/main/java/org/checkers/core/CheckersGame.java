package org.checkers.core;


public interface CheckersGame {


	/**
	 * Play a chip in a given column.
	 */
    void play(ChipColour colour, int column);

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
