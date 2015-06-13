package j2ee.purchase.controller;

import java.util.Date;
import java.util.List;

import j2ee.purchase.model.AccountTax;
import j2ee.purchase.model.Product;
import j2ee.purchase.service.AccountTaxService;
import j2ee.purchase.service.ProductService;
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
@RequestMapping(value = { "/product" })
public class ProductController {
	private static final Logger logger = LoggerFactory
			.getLogger(ProductController.class);

	private final String PAGE_NAME = "Product";

	@Autowired
	private ProductService productService;

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
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/list.do" }, method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		logger.info("Load Product List.");
		Init(model);
		model.addAttribute("TITLE", "List " + PAGE_NAME);
		model.addAttribute("PAGE_NAME", "List " + PAGE_NAME);

		Menu menu = new Menu(MENU.PRODUCTS, MENU_ITEM.PRODUCTS_PRODUCTS);
		model.addAttribute("MENU", menu);

		return "product/list";
	}

	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/create.do" }, method = RequestMethod.GET)
	public String create(Model model, HttpSession session) {
		logger.info("Load Product Create.");
		Init(model);
		model.addAttribute("TITLE", "Create " + PAGE_NAME);
		model.addAttribute("PAGE_NAME", "Create " + PAGE_NAME);

		// Load Account Tax
		List<AccountTax> lstAccountTax = accountTaxService.lstAccountTaxs();
		model.addAttribute("LIST_ACCOUNTTAX", lstAccountTax);

		return "product/create";
	}

	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/searchListProduct.do", method = RequestMethod.GET)
	@ResponseBody
	public Datatable doSearchListCompany(HttpSession session) {

		if (session.getAttribute("USERLOGIN") != null) {

			List<Product> lst = productService.lstProducts();

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
	 * @param txtName
	 * @param txtActive
	 * @param txtDescription
	 * @param txtSalePrice
	 * @param txtCostPrice
	 * @param txtWarranty
	 * @param txtCustomerLeadTime
	 * @param txtNote
	 * @param txtCustomerTaxes
	 * @param txtSupplierTaxes
	 * @param isUpdate
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/submitProduct.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJson doSubmitProduct(
			@RequestParam(value = "txtName") String txtName,
			@RequestParam(value = "txtActive", required = false, defaultValue = "false") Boolean txtActive,
			@RequestParam(value = "txtDescription", required = false, defaultValue = "") String txtDescription,
			@RequestParam(value = "txtSalePrice", required = false, defaultValue = "0") Double txtSalePrice,
			@RequestParam(value = "txtCostPrice", required = false, defaultValue = "0") Double txtCostPrice,
			@RequestParam(value = "txtWarranty", required = false, defaultValue = "0") Float txtWarranty,
			@RequestParam(value = "txtCustomerLeadTime", required = false, defaultValue = "0") Float txtCustomerLeadTime,
			@RequestParam(value = "txtNote", required = false, defaultValue = "") String txtNote,
			@RequestParam(value = "txtCustomerTaxes", required = false, defaultValue = "") String txtCustomerTaxes,
			@RequestParam(value = "txtSupplierTaxes", required = false, defaultValue = "") String txtSupplierTaxes,
			@RequestParam(value = "isUpdate", required = false, defaultValue = "false") Boolean isUpdate,
			@RequestParam(value = "uuid", required = false, defaultValue = "-1") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				Product product = null;
				if (isUpdate) {
					product = productService.getProductById(id);
				} else {
					product = new Product();
				}

				product.setActive(txtActive);
				product.setCostPrice(txtCostPrice);
				product.setCreateDate(new Date());
				product.setCustomerLeadTime(txtCustomerLeadTime);
				product.setDescription(txtDescription);
				product.setName(txtName);
				product.setSalePrice(txtSalePrice);
				product.setWarranty(txtWarranty);
				product.setNote(txtNote);

				AccountTax customerTaxes = accountTaxService
						.getAccountTaxById(txtCustomerTaxes);
				product.setCustomerTaxes(customerTaxes);
				AccountTax supplierTaxes = accountTaxService
						.getAccountTaxById(txtSupplierTaxes);
				product.setSupplierTaxes(supplierTaxes);
				
				if (isUpdate) {
					productService.updateProduct(product);
				} else {
					productService.addProduct(product);
				}

				result.setData(null);
				result.setStatus(true);
				result.setMsg("Success. ");
				return result;
			} catch (Exception e) {
				return result;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param id
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/viewProduct.do/{id}", method = RequestMethod.GET)
	public ModelAndView viewProduct(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load Product
			Product product = productService.getProductById(id);
			ModelAndView mv = null;
			if (product != null) {
				logger.info("Load Product View Id: " + id);
				mv = new ModelAndView("product/show");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "View Product ");
				mv.addObject("PAGE_NAME", "View " + PAGE_NAME);

				// Load Account Tax
				List<AccountTax> lstAccountTax = accountTaxService.lstAccountTaxs();
				mv.addObject("LIST_ACCOUNTTAX", lstAccountTax);

				mv.addObject("PRODUCT", product);
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

	@RequestMapping(value = "/deleteProduct.do", method = RequestMethod.GET)
	@ResponseBody
	public ResponseJson doDeleteProduct(@RequestParam("id") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				productService.removeProduct(id);
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

	@RequestMapping(value = "/editProduct.do/{id}", method = RequestMethod.GET)
	public ModelAndView editSupplier(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load Product
			Product product = productService.getProductById(id);
			ModelAndView mv = null;
			if (product != null) {
				logger.info("Load Product Edit Id: " + id);
				mv = new ModelAndView("product/update");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "Edit Product ");
				mv.addObject("PAGE_NAME", "Edit " + PAGE_NAME);

				// Load Account Tax
				List<AccountTax> lstAccountTax = accountTaxService.lstAccountTaxs();
				mv.addObject("LIST_ACCOUNTTAX", lstAccountTax);

				mv.addObject("PRODUCT", product);
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
