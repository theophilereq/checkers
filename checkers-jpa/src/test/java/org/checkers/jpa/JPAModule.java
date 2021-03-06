package org.checkers.jpa;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class JPAModule extends AbstractModule {

	@Override
	protected void configure() {

	}

	@Provides
	public UserTransaction getUserTransaction(final EntityManager em) {
		return new UserTransaction() {

			@Override
			public void setTransactionTimeout(int seconds) throws SystemException {

			}

			@Override
			public void setRollbackOnly() throws IllegalStateException, SystemException {

			}

			@Override
			public void rollback() throws IllegalStateException, SecurityException, SystemException {

			}

			@Override
			public int getStatus() throws SystemException {
				return 0;
			}

			@Override
			public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException,
					SecurityException, IllegalStateException, SystemException {
				em.getTransaction().commit();

			}

			@Override
			public void begin() throws NotSupportedException, SystemException {
				em.getTransaction().begin();
			}
		};
	}
}
