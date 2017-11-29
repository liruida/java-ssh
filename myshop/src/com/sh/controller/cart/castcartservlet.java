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

import com.sh.entity.paycart;
@Controller
@RequestMapping("/cart")
public class castcartservlet {
	
	
	@RequestMapping(value="/cast", method=RequestMethod.POST)
	public String cast( paycart paycart,HttpSession session, Model model){
		double num=paycart.getCount()*paycart.getPrice();
		model.addAttribute("num",num);
		return "pay";
		
	}
	@RequestMapping(value="/cast", method=RequestMethod.GET)
	public void nocasttodate(@Valid paycart paycart, BindingResult bindingResult,
			HttpSession session, Model model){
		
	}
}
