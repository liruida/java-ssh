package com.skishop.servlets.user;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skishop.dao.user.UserDaoImpl;
import com.skishop.entity.User;
import com.skishop.service.UserServiceImpl;


/**
 * Servlet implementation class zhuce
 */
@WebServlet("/zhuce")
public class zhuce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zhuce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		
		String password=request.getParameter("password");
		User u=new User();
		u.setNickName(username);
		u.setPassword(password);
		u.setRegistTime("2017-1-1");
		u.setGender("");
		u.setIntroduce("");
    	u.setIp("127.0.0.1");
		//String NickName=request.getParameter("NickName");
		//request.setAttribute("username",username);
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		int a=userServiceImpl.regist(u);
		
		request.setAttribute("id",a);
		
		request.getRequestDispatcher("tellpass.jsp").forward(request,response);
		//request.getRequestDispatcher("login.html").forward(request,response);
			
	}

}
