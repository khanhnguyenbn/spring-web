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
import vn.topica.itlab4.springweb.services.IUserService;
import vn.topica.itlab4.springweb.services.UserServiceImpl;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping(value = "/web/user/login")
	public ModelAndView displayLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@PostMapping("/web/user/login")
	public ModelAndView processLogin(@ModelAttribute("user") UserModel userModel, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		UserModel user = userService.findUserByUserName(userModel.getUserName());

		if (user != null) {
			if (userModel.getPassword().equals(user.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				modelAndView.setViewName("redirect:/web/product/home");
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

	@RequestMapping(value = "/web/user/logout")
	public ModelAndView logout(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.invalidate();
		
		ModelAndView modelAndView = new ModelAndView("login");

		return modelAndView;
	}

	@RequestMapping(value = "/web/*")
	public ModelAndView doLogin(HttpServletRequest request) {
		System.out.println("/////////////////////");
		HttpSession session = request.getSession();

		UserModel user = (UserModel) session.getAttribute("user");

		if (user == null) {
			return new ModelAndView("redirect:/web/user/login");
		} else {
			return new ModelAndView("redirect:/web/product/home");
		}

	}

}
