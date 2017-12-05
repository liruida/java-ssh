package com.sh.controller.cart;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.entity.paycart;
@Controller
@RequestMapping("/cart")
public class castcartservlet {
	
	
	@RequestMapping(value="/cast", method=RequestMethod.POST)
	public String cast(@RequestParam("price") String price,
			@RequestParam("count") String count,HttpSession session, Model model){
		int c=Integer.parseInt(count);
		int p=Integer.parseInt(price);
		int num=c*p;
		model.addAttribute("num",num);
		return "pay";
		
	}
	@RequestMapping(value="/cast", method=RequestMethod.GET)
	public void nocasttodate(@Valid paycart paycart, BindingResult bindingResult,
			HttpSession session, Model model){
		
	}
}
