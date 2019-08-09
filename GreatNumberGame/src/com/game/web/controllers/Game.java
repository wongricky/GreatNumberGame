package com.game.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/game.jsp");
		view.forward(request, response);
;	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        HttpSession session = request.getSession();

		Integer guessNumber = Integer.parseInt(request.getParameter("number").trim());
		
		Integer i = (Integer)session.getAttribute("count");
		if(i == null){
			i = 1;
		}
		else {
			i ++;
		}
		session.setAttribute("count", i);
		
		Random rand = new Random();
		if (session.getAttribute("mainNumber") == null) {
			session.setAttribute("mainNumber", rand.nextInt(100));
		}
		Integer mainNumber = (Integer)session.getAttribute("mainNumber");
		
		// Checks for "empty" or null values for "number"
//		if (request.getParameter("number").equals(null) || (request.getParameter("number").equals(""))) {
//			session.setAttribute("pick", "empty");
//			response.sendRedirect("GameGoTo");
//		}
		if (guessNumber.equals(mainNumber)) {
			session.setAttribute("pick", "correct");
	        response.sendRedirect("GameGoTo");
		} 
		else if (guessNumber < mainNumber) {
			session.setAttribute("pick", "low");
			response.sendRedirect("GameGoTo");
		}
		else if (guessNumber > mainNumber) {
			session.setAttribute("pick", "high");
			response.sendRedirect("GameGoTo");
		}
		
		
		
	}

}
