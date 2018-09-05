package com.iilm.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iilm.dao.UserDAO;

/**
 * Servlet implementation class LoginServlets
 */
@WebServlet("/login")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get called...");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service called");
		String userName = request.getParameter("username");
		System.out.println("User Name: "+ userName);
		String password = request.getParameter("password");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do Post called...");
		String userName = request.getParameter("username");
		System.out.println("User Name: "+ userName);
		String password = request.getParameter("password");
//		String redirectPage = " ";
		String message = null;
		if((userName == null || userName.equals("") )|| (password == null || password.equals(""))) {
			System.out.println("User Name and Password are required...");
			message = "User Name and Password are required.";
			response.sendRedirect("/WEB-INF/jsps/login.jsp?MESSAGE="+message);
		} else {
			UserDAO userDao = new UserDAO();
			Boolean userStatus = userDao.validateUser(userName, password);
			System.out.println("Status:" +userStatus);
			if(userStatus) {
				//Welcome Page
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/home.jsp");
				dispatcher.forward(request, response);
			} else {
				//Invalid Credentials
				System.out.println("Invalid credentials.");
				message = "Invalid credentials.";
				response.sendRedirect("/WEB-INF/jsps/login.jsp?MESSAGE="+message);
			}
		}
		/*else if(userName.equals("abc") && password.equals("abc@123")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsps/home.jsp");
			dispatcher.forward(request, response);
			redirectPage = "jsps/home.jsp";
		}
		else if (userName.equals("hr") && password.equals("hr@123"))
			
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsps/HR.jsp");
		    dispatcher.forward(request, response);
			redirectPage = "jsps/HR.jsp";
		}
		
		else if(userName.equals("manager") && password.equals("manager@123"))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsps/Manager.jsp");
		    dispatcher.forward(request, response);
			redirectPage = "jsps/Manager.jsp";
		}
		
		else if(userName.equals("reviewer") && password.equals("reviewer@123"))
		
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsps/Reviewer.jsp");
		    dispatcher.forward(request, response);
			redirectPage = "jsps/Reviewer.jsp";
		}
		else if(userName.equals("user")&& password.equals("user@123"))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsps/User.jsp");
		    dispatcher.forward(request, response);
			redirectPage = "jsps/Reviewer.jsp";
		}
		
		else {
			System.out.println("Invalid credentials.");
			message = "Invalid credentials.";
			response.sendRedirect("login.jsp?MESSAGE="+message);
			
		}*/
		/*RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
		dispatcher.forward(request, response);*/
	}

}
