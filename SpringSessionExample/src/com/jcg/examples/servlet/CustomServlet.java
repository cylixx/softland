package com.jcg.examples.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcg.examples.service.MultiLoginService;


@WebServlet("/customServlet")
public class CustomServlet extends HttpServlet
{
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
				doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
				HttpSession session = request.getSession();
				
				String userName = request.getParameter("userName");
				
				if(userName != null)
				{
						session.setAttribute("Username", request.getParameter("userName"));
				}
				
				MultiLoginService.createMultiLogin(request);
				
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				
				/*String url = response.encodeURL(request.getContextPath()+"/welcome.jsp?_s="+additionalURL);
				response.sendRedirect(url);*/
				rd.forward(request, response);
		}

}
