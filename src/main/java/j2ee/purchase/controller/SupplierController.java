package j2ee.purchase.controller;

import java.util.Date;
import java.util.List;

import j2ee.purchase.model.Company;
import j2ee.purchase.model.Partner;
import j2ee.purchase.model.User;
import j2ee.purchase.service.CompanyService;
import j2ee.purchase.service.PartnerService;
import j2ee.purchase.service.UserService;
import j2ee.purchase.utils.Datatable;
import j2ee.purchase.utils.Menu;
import j2ee.purchase.utils.ResponseJson;
import j2ee.purchase.utils.Menu.MENU;
import j2ee.purchase.utils.Menu.MENU_ITEM;

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

@Controller
@RequestMapping(value = { "/supplier" })
public class SupplierController {
	private static final Logger logger = LoggerFactory
			.getLogger(SupplierController.class);

	private final String PAGE_NAME = "Supplier";

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private UserService userService;

	/**
	 * Init
	 * 
	 * @param model
	 */
	private void Init(Model model) {
		model.addAttribute("URL", "../resources/");
		model.addAttribute("BASE_URL", "../");
	}

	@RequestMapping(value = { "/list.do" }, method = RequestMethod.GET)
	public String list(Model model, HttpSession session) {
		logger.info("Load Supplier List.");
		Init(model);
		model.addAttribute("TITLE", "List Supplier");
		model.addAttribute("PAGE_NAME", "List " + PAGE_NAME);

		Menu menu = new Menu(MENU.PURCHASE, MENU_ITEM.PURCHASE_SUPPLIERS);
		model.addAttribute("MENU", menu);

		return "supplier/list";
	}

	@RequestMapping(value = { "/create.do" }, method = RequestMethod.GET)
	public String create(Model model, HttpSession session) {
		logger.info("Load Supplier Create.");
		Init(model);
		model.addAttribute("TITLE", "Create Supplier");
		model.addAttribute("PAGE_NAME", "Create " + PAGE_NAME);

		Menu menu = new Menu(MENU.PURCHASE, MENU_ITEM.PURCHASE_SUPPLIERS);
		model.addAttribute("MENU", menu);

		// Load Company
		List<Company> lstCompany = companyService.lstCompanys();
		model.addAttribute("LIST_COMPANY", lstCompany);

		// Load Sale Person
		List<User> lstUser = userService.lstUsers();
		model.addAttribute("LIST_USER", lstUser);

		return "supplier/create";
	}

	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/searchListSupplier.do", method = RequestMethod.GET)
	@ResponseBody
	public Datatable doSearchListSupplier(HttpSession session) {

		if (session.getAttribute("USERLOGIN") != null) {

			List<Partner> lst = partnerService.lstPartners();

			Datatable result = new Datatable();
			result.setiTotalDisplayRecords(lst.size());
			result.setiTotalRecords(lst.size());
			result.setAaData(lst);

			return result;
		}

		return null;
	}

	@RequestMapping(value = "/submitSupplier.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJson doSubmitCompany(
			@RequestParam(value = "txtName") String txtName,
			@RequestParam(value = "txtEmail") String txtEmail,
			@RequestParam(value = "txtPhone") String txtPhone,
			@RequestParam(value = "txtMobile", required = false, defaultValue = "") String txtMobile,
			@RequestParam(value = "txtFax", required = false, defaultValue = "") String txtFax,
			@RequestParam(value = "txtWebsite", required = false, defaultValue = "") String txtWebsite,
			@RequestParam(value = "txtCompany", required = false, defaultValue = "-1") String txtCompany,
			@RequestParam(value = "txtStreet", required = false, defaultValue = "") String txtStreet,
			@RequestParam(value = "txtState", required = false, defaultValue = "") String txtState,
			@RequestParam(value = "txtZipCode", required = false, defaultValue = "") String txtZipCode,
			@RequestParam(value = "txtCountry", required = false, defaultValue = "") String txtCountry,
			@RequestParam(value = "txtCity", required = false, defaultValue = "") String txtCity,
			@RequestParam(value = "txtComment", required = false, defaultValue = "") String txtComment,
			@RequestParam(value = "txtIsCustomer", required = false, defaultValue = "false") Boolean txtIsCustomer,
			@RequestParam(value = "txtIsSupplier", required = false, defaultValue = "false") Boolean txtIsSupplier,
			@RequestParam(value = "txtActive", required = false, defaultValue = "false") Boolean txtActive,
			@RequestParam(value = "txtSalePerson", required = false, defaultValue = "-1") String txtSalePerson,
			@RequestParam(value = "isUpdate", required = false, defaultValue = "false") Boolean isUpdate,
			@RequestParam(value = "uuid", required = false, defaultValue = "-1") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				Partner partnet = null;
				if (isUpdate) {
					partnet = partnerService.getPartnerById(id);
				} else {
					partnet = new Partner();
				}

				partnet.setName(txtName);
				partnet.setPhone(txtPhone);
				partnet.setEmail(txtEmail);
				partnet.setActive(txtActive);
				partnet.setCity(txtCity);
				partnet.setComment_text(txtComment);

				Company company = companyService.getCompanyById(txtCompany);
				if (company != null) {
					partnet.setCompany(company);
					partnet.setIs_company(true);
				}

				partnet.setCountry(txtCountry);
				partnet.setCreate_date(new Date());
				partnet.setDisplay_name(txtName);
				partnet.setFax(txtFax);
				partnet.setIs_customer(txtIsCustomer);
				partnet.setIs_supplier(txtIsSupplier);
				partnet.setMobile(txtMobile);
				partnet.setState(txtState);
				partnet.setStreet(txtStreet);
				partnet.setWebsite(txtWebsite);
				partnet.setZipcode(txtZipCode);

				User user = userService.getUserById(txtSalePerson);
				partnet.setUser(user);

				if (isUpdate) {
					partnerService.updatePartner(partnet);
				} else {
					partnerService.addPartner(partnet);
				}

				result.setData(partnet);
				result.setStatus(true);
				result.setMsg("Success. ");
				return result;
			} catch (Exception e) {
				return result;
			}
		}
		return result;
	}

	@RequestMapping(value = "/viewSupplier.do/{id}", method = RequestMethod.GET)
	public ModelAndView viewSupplier(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load Supplier
			Partner partner = partnerService.getPartnerById(id);
			ModelAndView mv = null;
			if (partner != null) {
				logger.info("Load Supplier View Id: " + id);
				mv = new ModelAndView("supplier/show");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "View Supplier ");
				mv.addObject("PAGE_NAME", "View " + PAGE_NAME);

				Menu menu = new Menu(MENU.PURCHASE,
						MENU_ITEM.PURCHASE_SUPPLIERS);
				mv.addObject("MENU", menu);

				// Load Company
				List<Company> lstCompany = companyService.lstCompanys();
				mv.addObject("LIST_COMPANY", lstCompany);

				// Load Sale Person
				List<User> lstUser = userService.lstUsers();
				mv.addObject("LIST_USER", lstUser);

				mv.addObject("SUPPLIER", partner);
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

	@RequestMapping(value = "/deleteSupplier.do", method = RequestMethod.GET)
	@ResponseBody
	public ResponseJson doDeleteSupplier(@RequestParam("id") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				partnerService.removePartner(id);
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

	@RequestMapping(value = "/editSupplier.do/{id}", method = RequestMethod.GET)
	public ModelAndView editSupplier(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load Company
			Partner partner = partnerService.getPartnerById(id);
			ModelAndView mv = null;
			if (partner != null) {
				logger.info("Load Supplier Edit Id: " + id);
				mv = new ModelAndView("supplier/update");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "Edit Supplier ");
				mv.addObject("PAGE_NAME", "Edit " + PAGE_NAME);

				// Load Company
				List<Company> lstCompany = companyService.lstCompanys();
				mv.addObject("LIST_COMPANY", lstCompany);

				// Load Sale Person
				List<User> lstUser = userService.lstUsers();
				mv.addObject("LIST_USER", lstUser);

				mv.addObject("SUPPLIER", partner);
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
