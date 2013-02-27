package com.inmyshow.webbase.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inmyshow.webbase.dao.IUserDao;
import com.inmyshow.webbase.entity.User;

@Controller
public class TestAction {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestAction.class);
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
	@RequestMapping("/form")
	public String form(@RequestParam("filename") String name){
		LOGGER.debug("filename:"+name);
		return "testviews/helloWorld";//
	}
}
