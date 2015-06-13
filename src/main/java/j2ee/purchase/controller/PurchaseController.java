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
@RequestMapping(value = { "/purchase" })
public class PurchaseController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PurchaseController.class);

	@RequestMapping(value = { "/list_rfq.do" }, method = RequestMethod.GET)
	public String list_rfq(Model model, HttpSession session) {
		logger.info("Load On Request For Quotation.");
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
		model.addAttribute("TITLE", "ERP Admin | Request For Quotation");

		Menu menu = new Menu(MENU.PURCHASE, MENU_ITEM.PURCHASE_REQUEST_FOR_QUOTATION);
		model.addAttribute("MENU", menu);

		return "purchase/list_rfq";
	}
	
	@RequestMapping(value = { "/create_rfq.do" }, method = RequestMethod.GET)
	public String create_rfq(Model model, HttpSession session) {
		logger.info("Load On Request For Quotation.");
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
		model.addAttribute("TITLE", "ERP Admin | Create Request For Quotation");

		Menu menu = new Menu(MENU.PURCHASE, MENU_ITEM.PURCHASE_REQUEST_FOR_QUOTATION                                                                                                                                                                                                                                                                                     );
		model.addAttribute("MENU", menu);

		return "purchase/create_rfq";
	}
	
	@RequestMapping(value = { "/list_cft.do" }, method = RequestMethod.GET)
	public String list_cft(Model model, HttpSession session) {
		logger.info("Load On Request For Quotation.");
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
		model.addAttribute("TITLE", "ERP Admin | Request For Quotation");

		Menu menu = new Menu(MENU.PURCHASE, MENU_ITEM.PURCHASE_CALL_FOR_TENDERS);
		model.addAttribute("MENU", menu);

		return "purchase/list_cft";
	}
	
	@RequestMapping(value = { "/create_cft.do" }, method = RequestMethod.GET)
	public String create_cft(Model model, HttpSession session) {
		logger.info("Load On Request For Quotation.");
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
		model.addAttribute("TITLE", "ERP Admin | Create Request For Quotation");

		Menu menu = new Menu(MENU.PURCHASE, MENU_ITEM.PURCHASE_CALL_FOR_TENDERS                                                                                                                                                                                                                                                                                     );
		model.addAttribute("MENU", menu);

		return "purchase/create_cft";
	}
	
	
}
