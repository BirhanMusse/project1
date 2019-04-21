package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.ShaneScriptService;
import com.revature.service.ShaneScriptServiceImpl;

/**
 * Servlet implementation class LoginCheckServlet
 */
//@WebServlet("/login")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ShaneScriptService sss = new ShaneScriptServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("SSCLogin.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check whether session exists, and create one if not
				// overloaded version takes a boolean parameter, if false returns null when there is none
				HttpSession session = request.getSession();
				//grab credentials from request
			//	Credentials creds = new Credentials(request.getParameter("username"), request.getParameter("password"));
				//attempt to authenticate user
			//	User u = as.isValidUser(creds);
				if (sss.Employeelogin(request.getParameter("username"), request.getParameter("password")) == true) {
					System.out.println("shouldve work");
					response.sendRedirect("index");
				} else {
					session.setAttribute("problem", "invalid credentials");
					//otherwise redirect to login page
					System.out.println("nice try tho");
					System.out.println(request.getParameter("username"));
					System.out.println(request.getParameter("password"));
					System.out.println(sss.Employeelogin(request.getParameter("username"), request.getParameter("password")));
					System.out.println(sss.getIdFromLogin(request.getParameter("username"), request.getParameter("password")));
					response.sendRedirect("index");
				}
	}

}
