package org.checkers.rest;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.checkers.jpa.CheckersAdapter;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;

public class CheckersAPITest extends JerseyTest{
	
    @Override
    protected Application configure() {
        return new CheckersApplication();
    }

    @Test
    @Ignore
    public void itCanCreateAGame() throws Exception{
    	CheckersAdapter game = target("api").request(MediaType.APPLICATION_JSON)
    			.get(CheckersAdapter.class);
    	
    	assertThat(game.getToken()).isNotNull();
    }
}
