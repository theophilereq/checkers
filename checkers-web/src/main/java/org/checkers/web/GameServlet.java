package org.checkers.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/g/*")
public class GameServlet extends HttpServlet {

    @Inject
    CheckersBean game;

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        game.createNewGame();

        response.sendRedirect(request.getContextPath() + request.getServletPath());
    }
        
    


}