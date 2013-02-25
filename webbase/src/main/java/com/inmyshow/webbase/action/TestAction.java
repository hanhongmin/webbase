package com.inmyshow.webbase.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inmyshow.webbase.dao.IUserDao;
import com.inmyshow.webbase.entity.User;

@Controller
public class TestAction {
	@Resource(name="userDao")
	private IUserDao userDao;
	@RequestMapping("/user.do")
	public void dodododo(HttpServletResponse response) throws IOException {
		User u = userDao.getABCD(1L);
		response.getWriter().write(u.getName()+", fuck the World!");
		User u2 = userDao.get(User.class, 1L);
		response.getWriter().write(u2.getName()+", fuck the Mother!");
	}
	
	@RequestMapping("/helloWorld")
	public String helloWorld(Model model){
		model.addAttribute("message", "Hello World!");
		return "testviews/helloWorld";//
	}
}
