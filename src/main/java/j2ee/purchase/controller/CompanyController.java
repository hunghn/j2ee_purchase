package j2ee.purchase.controller;

import java.util.List;

import j2ee.purchase.model.Company;
import j2ee.purchase.service.CompanyService;
import j2ee.purchase.utils.Datatable;
import j2ee.purchase.utils.Menu;
import j2ee.purchase.utils.Menu.MENU;
import j2ee.purchase.utils.Menu.MENU_ITEM;
import j2ee.purchase.utils.ResponseJson;

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
 * @author trungpv
 *
 */

@Controller
@RequestMapping(value = { "/company" })
public class CompanyController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private final String PAGE_NAME = "Company";

	@Autowired
	private CompanyService companyService;

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
		logger.info("Load Company List.");
		Init(model);
		model.addAttribute("TITLE", "List Company");
		model.addAttribute("PAGE_NAME", "List " + PAGE_NAME);

		Menu menu = new Menu(MENU.MANAGER, MENU_ITEM.MANAGER_COMPANIES);
		model.addAttribute("MENU", menu);

		return "company/list";
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
		logger.info("Load Company Create.");
		Init(model);
		model.addAttribute("TITLE", "Create Company");
		model.addAttribute("PAGE_NAME", "Create " + PAGE_NAME);

		Menu menu = new Menu(MENU.MANAGER, MENU_ITEM.MANAGER_COMPANIES);
		model.addAttribute("MENU", menu);

		return "company/create";
	}

	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/searchListCompany.do", method = RequestMethod.GET)
	@ResponseBody
	public Datatable doSearchListCompany(HttpSession session) {

		if (session.getAttribute("USERLOGIN") != null) {

			List<Company> lst = companyService.lstCompanys();

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
	@RequestMapping(value = "/submitCompany.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJson doSubmitCompany(
			@RequestParam("email") String email,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("address") String address,
			@RequestParam(value = "isUpdate", required = false, defaultValue="false") Boolean isUpdate,
			@RequestParam(value = "uuid", required = false, defaultValue="-1") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				Company company = new Company();
				
				if (isUpdate) {
					company = companyService.getCompanyById(id);
					company.setName(name);
					company.setEmail(email);
					company.setAddress(address);
					company.setPhone(phone);
					companyService.updateCompany(company);
				} else {
					company.setName(name);
					company.setEmail(email);
					company.setAddress(address);
					company.setPhone(phone);
					companyService.addCompany(company);
				}

				result.setStatus(true);
				result.setMsg("Success. ");
				result.setData(company);
				return result;
			} catch (Exception e) {
				return result;
			}
		}
		return result;
	}

	@RequestMapping(value = "/viewCompany.do/{id}", method = RequestMethod.GET)
	public ModelAndView viewCompany(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load Company
			Company company = companyService.getCompanyById(id);
			ModelAndView mv = null;
			if (company != null) {
				logger.info("Load Company View Id: " + id);
				mv = new ModelAndView("company/show");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "View Company ");
				mv.addObject("PAGE_NAME", "View " + PAGE_NAME);

				Menu menu = new Menu(MENU.MANAGER, MENU_ITEM.MANAGER_COMPANIES);
				mv.addObject("MENU", menu);

				mv.addObject("COMPANY", company);
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

	@RequestMapping(value = "/deleteCompany.do", method = RequestMethod.GET)
	@ResponseBody
	public ResponseJson doDeleteCompany(@RequestParam("id") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				companyService.removeCompany(id);
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

	@RequestMapping(value = "/editCompany.do/{id}", method = RequestMethod.GET)
	public ModelAndView editCompany(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load Company
			Company company = companyService.getCompanyById(id);
			ModelAndView mv = null;
			if (company != null) {
				logger.info("Load Company Edit Id: " + id);
				mv = new ModelAndView("company/update");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "Edit Company ");
				mv.addObject("PAGE_NAME", "Edit " + PAGE_NAME);

				mv.addObject("COMPANY", company);
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
