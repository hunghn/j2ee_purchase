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
@RequestMapping(value={"/supplier"})
public class SupplierController {
	private static final Logger logger = LoggerFactory
			.getLogger(SupplierController.class);

	@RequestMapping(value = { "/list.do" }, method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		logger.info("Load Supplier List.");
		model.addAttribute("URL", "resources/");
		model.addAttribute("TITLE", "ERP Admin | List Supplier");

		Menu menu = new Menu(MENU.PURCHASE, MENU_ITEM.PURCHASE_SUPPLIERS                                                                                                                                                                                                                                                                                     );
		model.addAttribute("MENU", menu);

		return "supplier/list";
	}
}
