package com.skishop.servlets.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skishop.dao.product.ProductDao;
import com.skishop.entity.Product;
import com.skishop.entity.Productcolor;

/**
 * Servlet implementation class productdetails
 */

public class productdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		List list=new ArrayList();
		ProductDao pd=new ProductDao();
		Product p=pd.findById(Integer.parseInt(id));
		
		List pc=pd.findcolorById(Integer.parseInt(id));
		List pz=pd.findsizeById(Integer.parseInt(id));
		request.setAttribute("product",p);
		request.setAttribute("productcolor",pc);
		request.setAttribute("productsize",pz);
		request.getRequestDispatcher("single.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
