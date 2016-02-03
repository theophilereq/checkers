package org.checkers.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

@WebServlet(urlPatterns = "/g/*")
public class GameServlet extends HttpServlet {


	private static final long serialVersionUID = -1717626444319515434L;
	@Inject
    CheckersBean game;

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		String token = getTokenFromRequest(request);
		
		if(StringUtils.isEmpty(token) || request.getParameter("reset") != null){
			game.createNewGame();
			redirectToGameRoot(response, request);
		} else {
			game.loadFromToken(token);
			
		}

        game.createNewGame();

        response.sendRedirect(request.getContextPath() + request.getServletPath());
    }

	private void redirectToGameRoot(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.sendRedirect(request.getContextPath() 
				+ request.getServletPath() 
				+ "/" 
				+ game.getToken());
		
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		if(request == null){
			return "";
		}
		String token = request.getRequestURI().substring(
				request.getContextPath().length() 
				+ request.getServletPath().length() + 1);
		return token;
	}
        
    


}