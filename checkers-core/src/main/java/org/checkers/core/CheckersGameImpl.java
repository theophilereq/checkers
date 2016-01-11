package org.checkers.core;

import java.util.ArrayList;
import java.util.List;

import static org.checkers.core.ChipColour.BLACK;
import static org.checkers.core.ChipColour.WHITE;

public class CheckersGameImpl implements CheckersGame {

	public static final int COLUMNS_NUMBER = 10;
    public static final int ROWS_NUMBER = 10;
    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";

    ChipColour[][] board = new ChipColour[COLUMNS_NUMBER][ROWS_NUMBER];
    
    public CheckersGameImpl() {
        initBoard();
    }

    private void initBoard() {
    	
    	 for (int x = 0; x < COLUMNS_NUMBER; x++) {
    		 if(x%2 == 0) {
    			 board[x][1] = BLACK;
        		 board[x][3] = BLACK;
        		 board[x][7] = WHITE;
        		 board[x][9] = WHITE;
    		 }else{
    			 board[x][0] = BLACK;
        		 board[x][2] = BLACK;
        		 board[x][6] = WHITE;
        		 board[x][8] = WHITE;
    		 }
         }  	   	
    }

	public void play(ChipColour colour, int column) {
		// TODO Auto-generated method stub
		
	}

	public ChipColour getCell(int i, int j) {
		  if ( i < 0 || i >= getColumnsNumber()) {
	            return null;
	        }
		  if ( j < 0 || j >= getRowsNumber()) {
	            return null;
	        }
		  return board[i][j];
	}

	public int getColumnsNumber() {
		return COLUMNS_NUMBER;
	}

	public int getRowsNumber() {
		return ROWS_NUMBER;
	}

	public ChipColour getWinner() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

