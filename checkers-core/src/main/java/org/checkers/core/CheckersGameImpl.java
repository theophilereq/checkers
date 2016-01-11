package org.checkers.core;

import java.util.ArrayList;
import java.util.List;


public class CheckersGameImpl implements CheckersGame {

	public static final int COLUMNS_NUMBER = 10;
    public static final int ROWS_NUMBER = 10;
    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";

    List<List<ChipColour>> board = new ArrayList<>(COLUMNS_NUMBER);
    
    public CheckersGameImpl() {
        initBoard();
    }

    private void initBoard() {
    	
    	 for (int i = 0; i < COLUMNS_NUMBER; i++) {
             board.add(new ArrayList<ChipColour>(ROWS_NUMBER));
         }
       
    }

	public void play(ChipColour colour, int column) {
		// TODO Auto-generated method stub
		
	}

	public ChipColour getCell(int column, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getColumnsNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRowsNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ChipColour getWinner() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

