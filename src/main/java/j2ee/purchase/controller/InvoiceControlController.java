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
@RequestMapping(value = { "/invoice_control" })
public class InvoiceControlController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(SupplierController.class);

	@RequestMapping(value = { "/list.do" }, method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		logger.info("Load On Draft Invoice.");
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
		model.addAttribute("TITLE", "ERP Admin | On Draft Invoice");

		Menu menu = new Menu(MENU.INVOICE_CONTROL, MENU_ITEM.INVOICE_CONTROL_ON_DRAFT_INVOICES);
		model.addAttribute("MENU", menu);

		return "invoice_control/list";
	}
	
	@RequestMapping(value = { "/create.do" }, method = RequestMethod.GET)
	public String create(Model model, HttpSession session) {
		logger.info("Load On Draft Invoice.");
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
		model.addAttribute("TITLE", "ERP Admin | Create Draft Invoice");

		Menu menu = new Menu(MENU.INVOICE_CONTROL, MENU_ITEM.INVOICE_CONTROL_ON_DRAFT_INVOICES                                                                                                                                                                                                                                                                                     );
		model.addAttribute("MENU", menu);

		return "invoice_control/create";
	}
	
	@RequestMapping(value = { "/list_incomingshipment.do" }, method = RequestMethod.GET)
	public String home_incomingshipment(Model model, HttpSession session) {
		logger.info("Load On Draft Invoice.");
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
		model.addAttribute("TITLE", "ERP Admin | On Draft Invoice");

		Menu menu = new Menu(MENU.INVOICE_CONTROL, MENU_ITEM.INVOICE_CONTROL_ON_INCOMING_SHIPMENTS);
		model.addAttribute("MENU", menu);

		return "invoice_control/list_incomingshipment";
	}
	@RequestMapping(value = { "/create_incomingshipment.do" }, method = RequestMethod.GET)
	public String create_incomingshipment(Model model, HttpSession session) {
		logger.info("Load On Draft Invoice.");
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
		model.addAttribute("TITLE", "ERP Admin | Create Draft Invoice");

		Menu menu = new Menu(MENU.INVOICE_CONTROL, MENU_ITEM.INVOICE_CONTROL_ON_INCOMING_SHIPMENTS                                                                                                                                                                                                                                                                                     );
		model.addAttribute("MENU", menu);

		return "invoice_control/create_incomingshipment";
	}

}
