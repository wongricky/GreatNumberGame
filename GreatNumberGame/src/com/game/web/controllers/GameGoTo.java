package com.game.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GameGoTo
 */
@WebServlet("/GameGoTo")
public class GameGoTo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameGoTo() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		
		// If number is not valid (i.e. empty or null)
//		if (session.getAttribute("pick").equals("empty")) {
//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/game.jsp");
//			view.forward(request, response);
//			response.getWriter().print("Pick a valid number");
//		}
		if (session.getAttribute("pick").equals("correct")) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/win.jsp");
			view.forward(request, response);
		}
		else if (session.getAttribute("pick").equals("high")) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/high.jsp");
			view.forward(request, response);
		}
		else if (session.getAttribute("pick").equals("low")) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/low.jsp");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
