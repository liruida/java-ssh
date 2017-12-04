package com.sh.controller.product;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.List;
import com.sh.dao.product.ProductDao;
import com.sh.dao.user.UserDaoImpl;
import com.sh.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductListServlet {
	@Resource
	private ProductDao productDao;

	@RequestMapping("/productlist")
	public String productlist(Model model,HttpServletRequest request) {
		List<Product> list = this.productDao.findAll();
		model.addAttribute("products", list);
		String itemPath=request.getServletContext().getRealPath("/static/images");
		model.addAttribute("itemPath", itemPath);
		return "shop";
	}
}
