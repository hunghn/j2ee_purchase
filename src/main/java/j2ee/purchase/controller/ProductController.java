package j2ee.purchase.controller;

import j2ee.purchase.utils.Menu;
import j2ee.purchase.utils.Menu.MENU;
import j2ee.purchase.utils.Menu.MENU_ITEM;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/product" })
public class ProductController {
	private static final Logger logger = LoggerFactory
			.getLogger(SupplierController.class);

	@RequestMapping(value = { "/list.do" }, method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		logger.info("Load Product List.");
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
		model.addAttribute("TITLE", "List Product");

		Menu menu = new Menu(MENU.PRODUCTS, MENU_ITEM.PRODUCTS_PRODUCTS);
		model.addAttribute("MENU", menu);

		return "product/list";
	}
	
	@RequestMapping(value = { "/create.do" }, method = RequestMethod.GET)
	public String create(Model model, HttpSession session) {
		logger.info("Load Supplier List.");
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
		model.addAttribute("TITLE", "Create Product");

		Menu menu = new Menu(MENU.PRODUCTS, MENU_ITEM.PRODUCTS_PRODUCTS                                                                                                                                                                                                                                                                                     );
		model.addAttribute("MENU", menu);

		return "product/create";
	}
}
