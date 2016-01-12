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
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// If the column is even
				if (i % 2 == 0) {
					// Checks the position of the pieces
					switch (j) {
					case 1:
						assertThat(game.getCell(j, i)).isEqualTo(BLACK);
						break;
					case 3:
						assertThat(game.getCell(j, i)).isEqualTo(BLACK);
						break;
					case 7:
						assertThat(game.getCell(j, i)).isEqualTo(WHITE);
						break;
					case 9:
						assertThat(game.getCell(j, i)).isEqualTo(WHITE);
						break;
					default:
						assertThat(game.getCell(j, i)).isNull();
						break;
					}
				}
				// If the column is odd
				else {
					switch (j) {
					case 0:
						assertThat(game.getCell(j, i)).isEqualTo(BLACK);
						break;
					case 2:
						assertThat(game.getCell(j, i)).isEqualTo(BLACK);
						break;
					case 6:
						assertThat(game.getCell(j, i)).isEqualTo(WHITE);
						break;
					case 8:
						assertThat(game.getCell(j, i)).isEqualTo(WHITE);
						break;
					default:
						assertThat(game.getCell(j, i)).isNull();
						break;
					}
				}
			}
		}
	}

	@Test
	public void aPlayerMayMoveAPiece() throws Exception {
		game.selectPiece(null, 3, 0);
		assertThat(game.getCell(3, 0)).isEqualTo(BLACK);
		
		game.dropPiece(game.getCell(3, 0), 4, 1);
		assertThat(game.isThePieceAutorizeToMove(BLACK, 4, 1)).isTrue();
		assertThat(game.getCell(3, 0)).isNull();
		assertThat(game.getCell(4, 1)).isEqualTo(BLACK);

	}

}
