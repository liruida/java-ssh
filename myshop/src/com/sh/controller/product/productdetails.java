package com.sh.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sh.dao.product.ProductDao;
import com.sh.entity.Product;
import com.sh.entity.Productcolor;

/**
 * Servlet implementation class productdetails
 */

public class productdetails  {}
	/*private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public productdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
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

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
*/