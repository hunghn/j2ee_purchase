package j2ee.purchase.controller;

import j2ee.purchase.model.Unit;
import j2ee.purchase.service.UnitService;
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
@RequestMapping(value = { "/unit" })
public class UnitController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private final String PAGE_NAME = "Unit";

	@Autowired
	private UnitService unitService;

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
		logger.info("Load Unit List.");
		Init(model);
		model.addAttribute("TITLE", "List Unit");
		model.addAttribute("PAGE_NAME", "List " + PAGE_NAME);

		Menu menu = new Menu(MENU.MANAGER, MENU_ITEM.MANAGER_UNITS);
		model.addAttribute("MENU", menu);

		return "unit/list";
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
		logger.info("Load Unit List.");
		Init(model);
		model.addAttribute("TITLE", "Create Unit");
		model.addAttribute("PAGE_NAME", "Create " + PAGE_NAME);

		Menu menu = new Menu(MENU.MANAGER, MENU_ITEM.MANAGER_UNITS);
		model.addAttribute("MENU", menu);

		return "unit/create";
	}

	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/searchListUnit.do", method = RequestMethod.GET)
	@ResponseBody
	public Datatable doSearchListUnit(HttpSession session) {

		if (session.getAttribute("USERLOGIN") != null) {

			List<Unit> lst = unitService.lstUnit();

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
	 * @param name
	 * @param rouding
	 * @param active
	 * @param isUpdate
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/submitUnit.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJson doSubmitUnit(
			@RequestParam("name") String name,
			@RequestParam("rouding") Float rouding,
			@RequestParam(value = "active", required = false, defaultValue = "false") Boolean active,
			@RequestParam(value = "isUpdate", required = false, defaultValue = "false") Boolean isUpdate,
			@RequestParam(value = "uuid", required = false, defaultValue = "-1") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				Unit unit = new Unit();
				if (isUpdate) {
					unit = unitService.getUnitById(id);
					unit.setName(name);
					unit.setRouding(rouding);
					unit.setActive(active);
					unitService.updateUnit(unit);
					//
					result.setStatus(true);
					result.setMsg("Success. ");
					result.setData(unit);
					return result;
				} else {
					if (!unitService.checkExistUnit(name.trim())) {
						unit.setName(name);
						unit.setRouding(rouding);
						unit.setActive(active);
						unitService.addUnit(unit);
						//
						result.setStatus(true);
						result.setMsg("Success. ");
						result.setData(unit);
						return result;
					} else {
						result.setStatus(false);
						result.setMsg("Unit is exist. ");
					}
				}
			} catch (Exception e) {
				return result;
			}
		}
		return result;
	}

	@RequestMapping(value = "/viewUnit.do/{id}", method = RequestMethod.GET)
	public ModelAndView viewUnit(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load Unit
			Unit unit = unitService.getUnitById(id);
			ModelAndView mv = null;
			if (unit != null) {
				logger.info("Load Unit View Id: " + id);
				mv = new ModelAndView("unit/show");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "View Unit ");
				mv.addObject("PAGE_NAME", "View " + PAGE_NAME);

				Menu menu = new Menu(MENU.MANAGER,
						MENU_ITEM.MANAGER_UNITS);
				mv.addObject("MENU", menu);

				mv.addObject("UNIT", unit);
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

	@RequestMapping(value = "/deleteUnit.do", method = RequestMethod.GET)
	@ResponseBody
	public ResponseJson doDeleteUnit(@RequestParam("id") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				unitService.removeUnit(id);
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

	@RequestMapping(value = "/editUnit.do/{id}", method = RequestMethod.GET)
	public ModelAndView editUnit(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load Unit
			Unit unit = unitService.getUnitById(id);
			ModelAndView mv = null;
			if (unit != null) {
				logger.info("Load Unit Edit Id: " + id);
				mv = new ModelAndView("unit/update");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "Edit Unit ");
				mv.addObject("PAGE_NAME", "Edit " + PAGE_NAME);

				mv.addObject("UNIT", unit);
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
