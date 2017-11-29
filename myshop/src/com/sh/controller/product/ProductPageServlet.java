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
import com.sh.entity.Page;
import com.sh.entity.Product;

/**
 * Servlet implementation class ProductPageServlet
 */
public class ProductPageServlet {}
	/*private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public ProductPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取页码
		String pageNum=request.getParameter("pageNum");
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//2、根据页码查询相关数据
		ProductDao pd=new ProductDao();
		int count=pd.findCountByPage();
		List<Product> list=pd.findByPage(num, 2);
		Page<Product> p=new Page<Product>(num, 2);
		p.setList(list);
		p.setTotalCount(count);
		request.setAttribute("page", p);
		request.getRequestDispatcher("fenyezhanshi.jsp").forward(request, response);
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