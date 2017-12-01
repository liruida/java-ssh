package com.skishop.servlets.user;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import com.skishop.entity.User;
import com.skishop.dao.user.UserDaoImpl;
/**
 * Servlet implementation class denglu
 */

public class denglu extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public denglu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		
		String Num=request.getParameter("username");
		
		String password=request.getParameter("password");
	
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		User u=userDaoImpl.findByQqNumAndPassword(Num, password);
		HttpSession session = request.getSession();
		session.setAttribute("username",Num);
		if(u!=null){
			request.getRequestDispatcher("userzhuye.jsp").forward(request,response);
		}else{
			response.sendRedirect("login.html");
		}
		
}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		
		String Num=request.getParameter("username");
		
		String password=request.getParameter("password");
	
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		User u=userDaoImpl.findByQqNumAndPassword(Num, password);
		HttpSession session = request.getSession();
		session.setAttribute("username",Num);
		if(u!=null){
			request.getRequestDispatcher("userzhuye.jsp").forward(request,response);
		}else{
			response.sendRedirect("login.html");
		}
		
}
}
