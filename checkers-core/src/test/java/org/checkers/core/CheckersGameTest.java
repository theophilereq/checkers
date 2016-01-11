package org.checkers.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.checkers.core.PieceColour.BLACK;
import static org.checkers.core.PieceColour.WHITE;

import org.junit.Test;
import org.junit.Before;

public class CheckersGameTest {

	private CheckersGame game;

	@Before
	public void doBefore() throws Exception {
		game = new CheckersGameImpl();
	}

	@Test
	public void isBoardInitialized() throws Exception {
		//
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

	}

}
