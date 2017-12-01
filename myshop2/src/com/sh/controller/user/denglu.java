package com.sh.controller.user;

import java.io.IOException;
import javax.annotation.Resource;
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
	public String login(@RequestParam("username") int username, @RequestParam("password") String password, Model model,
			HttpSession session) {
		User u = this.userDaoImpl.findByQqNumAndPassword(username);
		session.setAttribute("username", username);
		if (u != null && password.equals(u.getPassword())) {
			return "userzhuye";
		} else {
			model.addAttribute("errorinfo", "您的账号密码不正确！");
			return "login";
		}

	}

}
