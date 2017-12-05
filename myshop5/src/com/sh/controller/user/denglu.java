package com.sh.controller.user;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.sh.entity.User;
import com.sh.dao.user.UserDaoImpl;

@Controller
@RequestMapping("/loginuser")
public class denglu {
	@Resource
	private UserDaoImpl userDaoImpl;

	@RequestMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model,HttpServletRequest request,
			HttpSession session) {
		//User u = this.userDaoImpl.findByQqNumAndPassword(username);此处的username是ID
		//session.setAttribute("username", username);
		
		User u = this.userDaoImpl.findByemail(email);
		
		if (u != null && password.equals(u.getPassword())) {
			int username=u.getQqnum();
			String nickname=u.getNickName();
			session.setAttribute("username", username);
			session.setAttribute("nickname", nickname);
			int statusnum=u.getEmailstatus();
			request.setAttribute("statusnum",statusnum);
			return "redirect:/loginuser/ifjihuoeamillogin?statusnum="+statusnum;
			
		} else {
			model.addAttribute("errorinfo", "您的账号密码不正确！");
			return "login";
		}

	}
	@RequestMapping("/ifjihuoeamillogin")
	public String ifjihuoeamillogin(Model model,@RequestParam("statusnum") String statusnum) {
		int statusnumemail=Integer.parseInt(statusnum.toString());
		System.out.println(statusnumemail);
	
		if ( statusnumemail==1) {

			return "userzhuye";
		} else {
			model.addAttribute("errorjihuo", "邮箱尚未激活");
			return "login";
		}
		
	}
}
