package com.sh.controller.user;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.dao.user.UserDaoImpl;
import com.sh.entity.User;
import com.sh.service.UserServiceImpl;
@Controller
@RequestMapping("/loginuser")
public class zhuce  {
	@Resource
	private UserServiceImpl userServiceImpl;
	
	
	
	@RequestMapping("/zhuce")
	public String zhuce(@RequestParam("username") String username,
			@RequestParam("password") String password,
			Model model){
		User u=new User();
		u.setNickName("kkk");
		u.setPassword(password);
		u.setRegistTime("2017-1-1");
		u.setGender("");
		u.setIntroduce("");
    	u.setIp("127.0.0.1");
        int a=this.userServiceImpl.regist(u);
		model.addAttribute("id",a);
	 return "tellpass";
	
	}
}