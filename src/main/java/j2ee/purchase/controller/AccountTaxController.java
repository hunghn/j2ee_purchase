package j2ee.purchase.controller;

import j2ee.purchase.model.AccountTax;
import j2ee.purchase.service.AccountTaxService;
import j2ee.purchase.utils.Datatable;
import j2ee.purchase.utils.Menu;
import j2ee.purchase.utils.Menu.MENU;
import j2ee.purchase.utils.Menu.MENU_ITEM;
import j2ee.purchase.utils.ResponseJson;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author tinhvv
 *
 */

@Controller
@RequestMapping(value = { "/account-tax" })
public class AccountTaxController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private final String PAGE_NAME = "Account Tax";

	@Autowired
	private AccountTaxService accountTaxService;

	/**
	 * Init
	 * 
	 * @param model
	 */
	private void Init(Model model) {
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
	}

	/**
	 * List Page
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/list.do" }, method = RequestMethod.GET)
	public String list(Model model, HttpSession session) {
		logger.info("Load Account Tax List.");
		Init(model);
		model.addAttribute("TITLE", "List Account Tax");
		model.addAttribute("PAGE_NAME", "List " + PAGE_NAME);

		Menu menu = new Menu(MENU.MANAGER, MENU_ITEM.MANAGER_ACCOUNT_TAX);
		model.addAttribute("MENU", menu);

		return "accounttax/list";
	}

	/**
	 * Create Page
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/create.do" }, method = RequestMethod.GET)
	public String create(Model model, HttpSession session) {
		logger.info("Load Account Tax List.");
		Init(model);
		model.addAttribute("TITLE", "Create Account Tax");
		model.addAttribute("PAGE_NAME", "Create " + PAGE_NAME);

		Menu menu = new Menu(MENU.MANAGER, MENU_ITEM.MANAGER_ACCOUNT_TAX);
		model.addAttribute("MENU", menu);

		return "accounttax/create";
	}

	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/searchListAccountTax.do", method = RequestMethod.GET)
	@ResponseBody
	public Datatable doSearchListAccountTax(HttpSession session) {

		if (session.getAttribute("USERLOGIN") != null) {

			List<AccountTax> lst = accountTaxService.lstAccountTaxs();

			Datatable result = new Datatable();
			result.setiTotalDisplayRecords(lst.size());
			result.setiTotalRecords(lst.size());
			result.setAaData(lst);

			return result;
		}

		return null;
	}

	/**
	 * 
	 * @param email
	 * @param name
	 * @param phone
	 * @param address
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/submitAccountTax.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJson doSubmitAccountTax(
			@RequestParam("name") String name,
			@RequestParam("amount") Float amount,
			@RequestParam(value = "active", required = false, defaultValue = "false") Boolean active,
			@RequestParam("description") String description,
			@RequestParam(value = "isUpdate", required = false, defaultValue = "false") Boolean isUpdate,
			@RequestParam(value = "uuid", required = false, defaultValue = "-1") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				AccountTax accountTax = new AccountTax();
				if (isUpdate) {
					accountTax = accountTaxService.getAccountTaxById(id);
					accountTax.setName(name);
					accountTax.setAmount(amount);
					accountTax.setActive(active);
					accountTax.setDescription(description);
					accountTaxService.updateAccountTax(accountTax);
					//
					result.setStatus(true);
					result.setMsg("Success. ");
					result.setData(accountTax);
					return result;
				} else {
					if (!accountTaxService.checkExistAccountTax(name.trim())) {
						accountTax.setName(name);
						accountTax.setAmount(amount);
						accountTax.setActive(active);
						accountTax.setDescription(description);
						accountTaxService.addAccountTax(accountTax);
						//
						result.setStatus(true);
						result.setMsg("Success. ");
						result.setData(accountTax);
						return result;
					} else {
						result.setStatus(false);
						result.setMsg("Account tax is exist. ");
					}
				}
			} catch (Exception e) {
				return result;
			}
		}
		return result;
	}

	@RequestMapping(value = "/viewAccountTax.do/{id}", method = RequestMethod.GET)
	public ModelAndView viewAccountTax(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load Company
			AccountTax accountTax = accountTaxService.getAccountTaxById(id);
			ModelAndView mv = null;
			if (accountTax != null) {
				logger.info("Load Account Tax View Id: " + id);
				mv = new ModelAndView("accounttax/show");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "View Account Tax ");
				mv.addObject("PAGE_NAME", "View " + PAGE_NAME);

				Menu menu = new Menu(MENU.MANAGER,
						MENU_ITEM.MANAGER_ACCOUNT_TAX);
				mv.addObject("MENU", menu);

				mv.addObject("ACCOUNTTAX", accountTax);
			} else {
				logger.info("Load 404");
				mv = new ModelAndView("error/404popup");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "Error 404 ");
				mv.addObject("PAGE_NAME", "Error 404 ");
			}

			return mv;
		}
		return null;
	}

	@RequestMapping(value = "/deleteAccountTax.do", method = RequestMethod.GET)
	@ResponseBody
	public ResponseJson doDeleteAccountTax(@RequestParam("id") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				accountTaxService.removeAccountTax(id);
				result.setStatus(true);
				result.setMsg("Delete Success.");
				return result;
			} catch (Exception e) {
				result.setMsg("Can't Delete ");
				return result;
			}
		}
		return result;
	}

	@RequestMapping(value = "/editAccountTax.do/{id}", method = RequestMethod.GET)
	public ModelAndView editAccountTax(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load Account tax
			AccountTax accountTax = accountTaxService.getAccountTaxById(id);
			ModelAndView mv = null;
			if (accountTax != null) {
				logger.info("Load Account Tax Edit Id: " + id);
				mv = new ModelAndView("accounttax/update");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "Edit Account Tax ");
				mv.addObject("PAGE_NAME", "Edit " + PAGE_NAME);

				mv.addObject("ACCOUNTTAX", accountTax);
			} else {
				logger.info("Load 404");
				mv = new ModelAndView("error/404popup");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "Error 404 ");
				mv.addObject("PAGE_NAME", "Error 404 ");
			}

			return mv;
		}
		return null;
	}
}
