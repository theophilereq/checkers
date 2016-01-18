package org.checkers.rest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.checkers.jpa.CheckersAdapter;

public class CheckersGameResource {

    @Context
    UriInfo info;
    
    private CheckersAdapter game;
    
    public CheckersGameResource(CheckersAdapter game){
    	this.game = game;
    }
    
    @GET
    public CheckersAdapter doGet() throws IOException {
    	return game;
    }
	
}
