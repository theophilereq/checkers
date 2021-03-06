package org.checkers.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.checkers.core.PieceColour;
import org.checkers.jpa.JPAModule;
import org.checkers.jpa.guice.GuiceRunner;
import org.checkers.jpa.guice.H2DBModule;
import org.checkers.jpa.guice.Modules;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GuiceRunner.class)
@Modules({ H2DBModule.class, JPAModule.class })
public class CheckersDAOTest {
	
	   @Inject
	    EntityManager em;
	   
	   @Inject
	   CheckersDAO dao;
	   
	   @Test
	   public void daoIsInjected() throws Exception {
		   assertThat(dao).isNotNull();
	   }
	   
	   @Test
	   public void itCanCreatGame() throws Exception {
		   CheckersAdapter game = dao.createNewGame();
		   assertThat(game).isNotNull();
		   
		   String token = game.getToken();
		   assertThat(game.getToken()).isNotNull();
		   em.clear();
		   game = dao.loadFromToken(token);
		   assertThat(game).isNotNull();
	   }
	   
	   @Test
	   public void itCanPlayWithAJPAGame() throws Exception {
		   CheckersAdapter game = dao.createNewGame();
		   game.movePiece(PieceColour.BLACK, 0, 3, 1, 4);
		   
		   assertThat(game.getCell(1, 4)).isEqualTo(PieceColour.BLACK);
		   String token = game.getToken();
		   
		   em.clear();
		   game = dao.loadFromToken(token);
		   assertThat(game).isNotNull();
		   assertThat(game.getCell(1, 4)).isEqualTo(PieceColour.BLACK);
	   }
	   
	   @Test
	   public void adapterManagesTurn() throws Exception {
		   CheckersAdapter game = dao.createNewGame();
		   assertThat(game.getCurrentTurn()).isNotNull();
		   assertThat(game.getCurrentTurn()).isEqualTo(PieceColour.WHITE);
		   game = dao.loadFromToken(game.getToken());
		   assertThat(game.getCurrentTurn()).isEqualTo(PieceColour.WHITE);
	   }
}
