package org.checkers.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.commons.lang.RandomStringUtils;

public class CheckersDAO {
	
	@Inject
	EntityManager em;
	
    @Inject
    UserTransaction ut;
    
    public CheckersAdapter createNewGame(){
    	Game game = new Game();
    	game.setToken(RandomStringUtils.randomAlphanumeric(10).toLowerCase());
    	try{
    		ut.begin();
    		em.persist(game);
    		ut.commit();
    	} catch (NotSupportedException | SystemException | SecurityException
                | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException e) {
            return null;
    	}
    	return new CheckersAdapter(this, game);
    }
    
    public CheckersAdapter loadFromToken(String token){
    	Game game = (Game) em
    			.createQuery("SELECT g FROM Game g WHERE g.token = :token")
    			.setParameter("token", token).getSingleResult();
    	return new CheckersAdapter(this, game);
    }
    
    public void save(Game game){
    	try {
            ut.begin();
            em.merge(game);
            ut.commit();
    	} catch (SecurityException | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }
    }

}
