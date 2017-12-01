package com.skishop.servlets.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skishop.dao.product.ProductColorDao;
import com.skishop.dao.product.ProductDao;
import com.skishop.entity.showcart;
import com.skishop.service.Cart;
import com.skishop.service.CartItem;

/**
 * Servlet implementation class ShowCartServlet
 */

public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Cart c=(Cart)session.getAttribute("cart");
		Iterator i=c.container.values().iterator();
		List list=new ArrayList();
		
		int id=Integer.parseInt((String) session.getAttribute("username"));
		while(i.hasNext()){
			CartItem ci=(CartItem)i.next();
			showcart show=new showcart();
			
			show.setId(id);
			show.setProductname(ci.getProduct().getName());
			show.setCount(ci.getCount());
			ProductDao acart=new ProductDao();
			acart.addshowcart(show);
			out.println(ci.getProduct().getName()+":"+ci.getCount()+"<br>");
			list.add(show);
			request.setAttribute("showcartobject",list);
			
		}
		
		request.getRequestDispatcher("cast.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
