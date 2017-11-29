package com.sh.controller.product;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.dao.product.ProductDao;
import com.sh.dao.product.ProductTypeDao;
import com.sh.entity.Product;
import com.sh.entity.ProductType;

/**
 * Servlet implementation class ProductEditServlet
 */
//@WebServlet("/editProduct")
public class ProductEditServlet  {}
	/*private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public ProductEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		ProductDao pd=new ProductDao();
		Product p=pd.findById(Integer.parseInt(id));
		request.setAttribute("product", p);
		request.setAttribute("action", "edit");
		ProductTypeDao ptd=new ProductTypeDao();
		List<ProductType> list=ptd.findAll();
		request.setAttribute("pts", list);
		request.getRequestDispatcher("editproduct.jsp").forward(request, response);
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
*/