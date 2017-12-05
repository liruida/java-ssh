package com.sh.controller.cart;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sh.dao.product.ProductDao;
import com.sh.dao.user.UserDaoImpl;
import com.sh.entity.Product;
import com.sh.service.Cart;

@Controller
@RequestMapping("/cart")
public class CartServlet {

	@Resource
	private ProductDao productDao;

	@RequestMapping("/addtocart")
	public String addtocart(@RequestParam("productId") int id, Model model, HttpSession session) {
		Product p = this.productDao.findById(id);
		Cart c = (Cart) session.getAttribute("cart");
		if (c == null) {
			c = new Cart();
		}
		System.out.println("id:"+id);
		c.addCart(p);
		session.setAttribute("cart", c);
		
		return "redirect:/product/productlist?pageNum=1";
	}
}
