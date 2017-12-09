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

import com.sh.dao.cart.cartDao;
import com.sh.dao.product.ProductColorDao;
import com.sh.dao.product.ProductDao;
import com.sh.entity.Product;
import com.sh.entity.showcart;
import com.sh.service.Cart;
import com.sh.service.CartItem;
@Controller
@RequestMapping("/cart")

public class ShowCartServlet  {
	@Resource
	private ProductDao productDao;
	
	@Resource
	private cartDao cd;

	@RequestMapping("/showcart")
	public String showcart( Model model, HttpSession session) {
		List<showcart> list = this.cd.showdingdan();
		model.addAttribute("showcartobject", list);
		return "cast";
	}
	
}