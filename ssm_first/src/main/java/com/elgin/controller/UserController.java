package com.elgin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.elgin.entities.User;
import com.elgin.service.UserService;

@Controller
public class UserController {
    
	@Autowired
	private UserService userService;
	
	@RequestMapping("register.jhtml")
	public void Regiseter(HttpServletRequest request, HttpServletResponse response, User user) throws IOException, ServletException {
		int result = 0;
		if (user != null) {
			result = userService.addUser(user);
		}
		if (result > 0) {
			response.sendRedirect("/allUser.jhtm");
		} else {
			request.getRequestDispatcher("/").forward(request, response);
		}
	}
	
	@RequestMapping("allUser.jhtm")
	public String  listUser(ModelMap mm) {
		List<User> list=userService.getUserList();
		mm.put("list", list);
		return "/userlist";
	}
	
	@RequestMapping("addpage.jhtml")
	public ModelAndView add(){
		System.out.println("add page...");
		return new ModelAndView("/register");
	}
	
	
}
