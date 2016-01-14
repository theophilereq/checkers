package org.checkers.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

public class CheckersDAO {
	
	@Inject
	EntityManager em;
	
    @Inject
    UserTransaction ut;

}
