package com.sh.controller.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.dao.product.ProductColorDao;
import com.sh.dao.product.ProductDao;
import com.sh.entity.showcart;
import com.sh.service.Cart;
import com.sh.service.CartItem;
@Controller
@RequestMapping("/cart")

public class ShowCartServlet  {
	@Resource
	private ProductDao productDao;

	@RequestMapping("/showcart")
	public String showcart( Model model, HttpSession session) {
		Cart c=(Cart)session.getAttribute("cart");
		System.out.println(c);
		Iterator i=c.container.values().iterator();
		List list=new ArrayList();
		Object obj=session.getAttribute("username");
		int id=Integer.parseInt(obj.toString());
		while(i.hasNext()){
			CartItem ci=(CartItem)i.next();
			System.out.println(ci.getProduct().getName()+":"+ci.getCount()+"<br>");
			showcart show=new showcart();
			
			show.setId(id);
			show.setProductname(ci.getProduct().getName());
			show.setCount(ci.getCount());
			show.setPrice(ci.getProduct().getPrice());
			show.setState(0);
			this.productDao.addshowcart(show);
			list.add(show);
			model.addAttribute("showcartobject",list);
			
		}
		
		return "cast";
	}
	
}