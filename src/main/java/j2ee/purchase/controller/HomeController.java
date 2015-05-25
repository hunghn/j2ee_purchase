package j2ee.purchase.controller;

import j2ee.purchase.model.Company;
import j2ee.purchase.model.User;
import j2ee.purchase.service.CompanyService;
import j2ee.purchase.service.PartnerService;
import j2ee.purchase.service.UserService;
import j2ee.purchase.utils.Menu;
import j2ee.purchase.utils.Menu.MENU;
import j2ee.purchase.utils.Menu.MENU_ITEM;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private UserService userService;
	private CompanyService companyService;
	private PartnerService partnerService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired(required = true)
	@Qualifier(value = "companyService")
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	@Autowired(required = true)
	@Qualifier(value = "partnerService")
	public void setPartnerService(PartnerService partnerService) {
		this.partnerService = partnerService;
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		logger.info("Load Login.");
		model.addAttribute("URL", "resources/");
		model.addAttribute("BASE_URL", "./");
		model.addAttribute("TITLE", "ERP Admin | Log in");
		
		return "login";
	}

	@RequestMapping(value = { "/home.do" }, method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		logger.info("Load Home Page.");
		model.addAttribute("URL", "resources/");
		model.addAttribute("BASE_URL", "./");
		model.addAttribute("TITLE", "ERP Admin | Dashboard");

		Menu menu = new Menu(MENU.DRASHBOAD, MENU_ITEM.NONE);
		model.addAttribute("MENU", menu);
		
		return "index";
	}

	@RequestMapping(value = { "/login.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String login(Model model, HttpServletResponse response)
			throws IOException {
		response.sendRedirect("./home.do");
		return "true";
	}
}
