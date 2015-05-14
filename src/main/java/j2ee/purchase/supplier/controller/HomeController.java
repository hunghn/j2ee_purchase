package j2ee.purchase.supplier.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		logger.info("Load Login.");
		model.addAttribute("URL", "resources/");
		
		return "login";
	}
	
	@RequestMapping(value = { "/home.do" }, method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		logger.info("Load Home Page.");
		model.addAttribute("URL", "resources/");
		
		return "index";
	}
	
	@RequestMapping(value={"/login.do"}, method = RequestMethod.POST)
	@ResponseBody
	public String login(Model model, HttpServletResponse response) throws IOException{
		response.sendRedirect("./home.do");
		return "true";
	}
}
