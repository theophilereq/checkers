package org.checkers.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.checkers.core.PieceColour.BLACK;
import static org.checkers.core.PieceColour.WHITE;

import org.junit.Before;
import org.junit.Test;

public class CheckersGameTest {

	private CheckersGame game;

	@Before
	public void doBefore() throws Exception {
		game = new CheckersGameImpl();
	}

	@Test
	public void boardInitialized() throws Exception {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// If the column is even
				if (i % 2 == 0) {
					// Checks the position of the pieces
					switch (j) {
					case 1:
						assertThat(game.getCell(i, j)).isEqualTo(BLACK);
						break;
					case 3:
						assertThat(game.getCell(i, j)).isEqualTo(BLACK);
						break;
					case 7:
						assertThat(game.getCell(i, j)).isEqualTo(WHITE);
						break;
					case 9:
						assertThat(game.getCell(i, j)).isEqualTo(WHITE);
						break;
					default:
						assertThat(game.getCell(i, j)).isNull();
						break;
					}
				}
				// If the column is odd
				else {
					switch (j) {
					case 0:
						assertThat(game.getCell(i, j)).isEqualTo(BLACK);
						break;
					case 2:
						assertThat(game.getCell(i, j)).isEqualTo(BLACK);
						break;
					case 6:
						assertThat(game.getCell(i, j)).isEqualTo(WHITE);
						break;
					case 8:
						assertThat(game.getCell(i, j)).isEqualTo(WHITE);
						break;
					default:
						assertThat(game.getCell(i, j)).isNull();
						break;
					}
				}
			}
		}
	}

	@Test
	public void aPlayerMayMoveAPiece() throws Exception {
		game.movePiece(game.getCell(0, 3), 0, 3, 1, 4);
		assertThat(game.getCell(0, 3)).isNull();
		assertThat(game.getCell(1, 4)).isEqualTo(BLACK);
	}
	
	@Test
	public void aPlayerMayEatAPiece() throws Exception {
		game.movePiece(WHITE, 3, 6, 4, 5);
		game.movePiece(BLACK, 4, 3, 5, 4);
		game.movePiece(WHITE, 1, 6, 0, 5);
		game.movePiece(BLACK, 5, 4, 3, 6);
		assertThat(game.getCell(3, 6)).isEqualTo(BLACK);
		assertThat(game.getCell(4, 5)).isNull();
	}
	
	@Test
	public void aPlayerMayWin() throws Exception {
		game.movePiece(WHITE, 3, 6, 4, 5);
		game.movePiece(BLACK, 2, 3, 3, 4);
		game.movePiece(WHITE, 5, 6, 6, 5);
		game.movePiece(BLACK, 3, 4, 5, 6);
		game.movePiece(WHITE, 2, 7, 3, 6);
		game.movePiece(BLACK, 8, 3, 9, 4);
		game.movePiece(WHITE, 3, 8, 2, 7);
		game.movePiece(BLACK, 5, 6, 3, 8);
		game.movePiece(WHITE, 5, 8, 4, 7);
		game.movePiece(BLACK, 9, 4, 8, 5);
		game.movePiece(WHITE, 4, 9, 5, 8);
		game.movePiece(BLACK, 3, 8, 4, 9);
		assertThat(game.getWinner()).isEqualTo(BLACK);
	}

	@Test
	public void itCantPlayOutsideOfTheBoard() throws Exception {
		try {
			game.movePiece(BLACK, 5, 20, 5, 5);
			fail("It should not be possible to play outside of the board");
		} catch (GameException e) {
			
		}
		
		try {
			game.movePiece(BLACK, 20, 5, 5, 5);
			fail("It should not be possible to play outside of the board");
		} catch(GameException e) {
			
		}
		
		try {
			game.movePiece(BLACK, 5, 5, 5, 20);
			fail("It should not be possible to play outside of the board");
		} catch (GameException e) {
			
		}
		
		try {
			game.movePiece(BLACK, 5, 5, 20, 5);
			fail("It should not be possible to play outside of the board");
		} catch(GameException e) {
			
		}
	}
	
	@Test
	public void itCantSelectAnEmptyCell() throws Exception {
		try {
			game.movePiece(BLACK, 0, 0, 5 ,5);
			fail("It should not be possible to select an empty cell");
		} catch (GameException e) {
			
		}
	}
	
	@Test
	public void itCantDropAPieceOnAnother() throws Exception {
		try {
			game.movePiece(BLACK, 1, 0, 2, 1);
			fail("It should not be possible to drop a piece on another");
		} catch (GameException e) {
			
		}
	}
	
	@Test
	public void aPieceCantMakeABigMovement() throws Exception {
		try {
			game.movePiece(BLACK, 1, 0, 5, 5);
			fail("It should not be authorized to do this movement");
		} catch (GameException e) {
			
		}
	}
	
}
