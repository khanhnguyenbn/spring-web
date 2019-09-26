package vn.topica.itlab4.springweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.topica.itlab4.springweb.model.UserModel;
import vn.topica.itlab4.springweb.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/user/login")
	public ModelAndView displayLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@PostMapping("/user/login")
	public ModelAndView processLogin(@ModelAttribute("user") UserModel userModel, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		UserModel user = userService.findUserByUserName(userModel.getUserName());

		if (user != null) {
			if (userModel.getPassword().equals(user.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", user.getId());
				modelAndView.setViewName("/home/index");
				return modelAndView;
			} else {
				modelAndView.addObject("msg", "Your password is not correct !");
				modelAndView.setViewName("login");
				return modelAndView;
			}

		} else {
			modelAndView.addObject("msg", "User Name is not correct !");
			modelAndView.setViewName("login");
			return modelAndView;
		}
	}
	
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/*")
	public ModelAndView doLogin(HttpServletRequest request) {
		System.out.println("/////////////////////");
		HttpSession session = request.getSession();
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId == null) {
			return new ModelAndView("/user/login");
		} else {
			return new ModelAndView("/home/index");
		}
		
		
	}

}
