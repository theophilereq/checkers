package org.checkers.rest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
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
    
    @POST
    @Path("{colNumber}")
    public Response playColumn(@PathParam("colNumber") int col) throws IOException{
    	return Response
    			.status(Response.Status.SEE_OTHER)
    			.header(HttpHeaders.LOCATION, 
    					info.getBaseUri() + game.getToken())
    			.build();
    }
	
}
