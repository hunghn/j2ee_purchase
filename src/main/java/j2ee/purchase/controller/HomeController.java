package j2ee.purchase.controller;

import j2ee.purchase.model.User;
import j2ee.purchase.service.UserService;
import j2ee.purchase.utils.Menu;
import j2ee.purchase.utils.Menu.MENU;
import j2ee.purchase.utils.Menu.MENU_ITEM;
import j2ee.purchase.utils.Security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author trungpv
 *
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/index", "/login.do" }, method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		logger.info("Load Login.");
		model.addAttribute("URL", "resources/");
		model.addAttribute("BASE_URL", "./");
		model.addAttribute("TITLE", "Log in");

		String token = Security.getSalt();
		model.addAttribute("TOKEN", token);

		session.setAttribute("TOKEN", token);

//		User user = new User();
//		user.setActive(true);
//		user.setEmail("vovantinhpy@gmail.com");
//		String salt = Security.getSalt();
//		user.setSalt(salt);
//		user.setPassword(Security.encryptPassword("123" + salt));
//		user.setUser_type(1);
//		user.setUsername("tinhvv");
//		user.setCreate_date(new Date());
//
//		userService.addUser(user);

		return "login";
	}

	@RequestMapping(value = { "/home.do" }, method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		logger.info("Load Home Page.");
		model.addAttribute("URL", "resources/");
		model.addAttribute("BASE_URL", "./");
		model.addAttribute("TITLE", "Dashboard");

		Menu menu = new Menu(MENU.DRASHBOAD, MENU_ITEM.NONE);
		model.addAttribute("MENU", menu);

		return "index";
	}

	@RequestMapping(value = { "/login.do" }, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("token") String token, HttpSession session,
			HttpServletResponse response, HttpServletRequest resquest)
			throws IOException {
		String sstoken = (String) session.getAttribute("TOKEN");

		if (token.equals(sstoken)) {
			if (userService.login(email, password)) {
				User user = userService.getUserByEmail(email);
				session.setAttribute("USERLOGIN", user);

				ModelAndView model = new ModelAndView("index");
				logger.info("Load Home Page.");
				model.addObject("URL", "resources/");
				model.addObject("BASE_URL", "./");
				model.addObject("TITLE", "Dashboard");

				Menu menu = new Menu(MENU.DRASHBOAD, MENU_ITEM.NONE);
				model.addObject("MENU", menu);

				return model;
			} else {
				resquest.setAttribute("MSG",
						"Please Check UserName & Password.");
			}
		} else {
			resquest.setAttribute("MSG", "Invalid or expired token.");
		}
		logger.info("Load Login.");
		ModelAndView model = new ModelAndView("login");
		model.addObject("URL", "resources/");
		model.addObject("BASE_URL", "./");
		model.addObject("TITLE", "Log in");
		return model;
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	@ResponseBody
	public String doLogout(HttpSession session, HttpServletResponse response) {

		User user = (User) session.getAttribute("USERLOGIN");

		if (user != null) {
			session.setAttribute("USERLOGIN", null);
			session.invalidate();

			try {
				response.sendRedirect("./");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "true";
		}

		return "false";
	}
	
	@RequestMapping(value = { "/404", }, method = RequestMethod.GET)
	public String error404(Model model, HttpSession session) {
		logger.info("Load Error 404 Page.");
		model.addAttribute("URL", "resources/");
		model.addAttribute("BASE_URL", "./");
		model.addAttribute("TITLE", "Error 404");

		return "error/404";
	}

}
