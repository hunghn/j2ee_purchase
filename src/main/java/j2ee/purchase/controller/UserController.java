package j2ee.purchase.controller;

import j2ee.purchase.model.User;
import j2ee.purchase.model.UserView;
import j2ee.purchase.service.UserService;
import j2ee.purchase.utils.Datatable;
import j2ee.purchase.utils.Menu;
import j2ee.purchase.utils.Menu.MENU;
import j2ee.purchase.utils.Menu.MENU_ITEM;
import j2ee.purchase.utils.ResponseJson;
import j2ee.purchase.utils.Security;

import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping(value = { "/user" })
public class UserController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private final String PAGE_NAME = "User Management";
	private final String PASSWORD_DEFAULT = "123456";

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

	/**
	 * List Page
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/list.do" }, method = RequestMethod.GET)
	public String list(Model model, HttpSession session) {
		logger.info("Load User List.");
		Init(model);
		model.addAttribute("TITLE", "List User");
		model.addAttribute("PAGE_NAME", "List " + PAGE_NAME);

		Menu menu = new Menu(MENU.MANAGER, MENU_ITEM.MANAGER_USER);
		model.addAttribute("MENU", menu);

		return "user/list";
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
		logger.info("Load User List.");
		Init(model);
		model.addAttribute("TITLE", "Create User");
		model.addAttribute("PAGE_NAME", "Create " + PAGE_NAME);

		Menu menu = new Menu(MENU.MANAGER, MENU_ITEM.MANAGER_COMPANIES);
		model.addAttribute("MENU", menu);

		return "user/create";
	}

	// Date create_date, String username, String email,
	// String password, String salt, String user_type, Date login_date
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/searchListUser.do", method = RequestMethod.GET)
	@ResponseBody
	public Datatable doSearchListUser(HttpSession session) {

		if (session.getAttribute("USERLOGIN") != null) {

			List<User> lst = userService.lstUsers();
			List<UserView> lstView = new ArrayList<UserView>();
			for (int i = 0; i < lst.size(); i++) {
				UserView user = new UserView(lst.get(i).getCreate_date(), lst
						.get(i).getUsername(), lst.get(i).getEmail(), lst
						.get(i).getPassword(), lst.get(i).getSalt(), lst.get(i)
						.getUser_type().toString(), lst.get(i).getLogin_date());
				user.setActive(lst.get(i).getActive());
				user.setId(lst.get(i).getId());

				lstView.add(user);
			}
			//
			Datatable result = new Datatable();
			result.setiTotalDisplayRecords(lstView.size());
			result.setiTotalRecords(lstView.size());
			result.setAaData(lstView);

			return result;
		}

		return null;
	}

	/**
	 * @param create_date
	 * @param username
	 * @param email
	 * @param password
	 * @param salt
	 * @param user_type
	 * @param login_date
	 * @param session
	 * @return
	 */

	Date create_date;
	String username;
	String email;
	String password;
	String salt;
	Integer user_type;
	Date login_date;

	@RequestMapping(value = "/submitUser.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseJson doSubmitUser(
			@RequestParam("username") String username,
			@RequestParam("email") String email,
			@RequestParam(value = "password", required = false, defaultValue = "") String password,
			@RequestParam(value = "user_type" ,required = false, defaultValue = "1") Integer user_type,
			@RequestParam(value = "active",required = false, defaultValue = "false" ) Boolean active,
			@RequestParam(value = "is_auto_create", required = false, defaultValue = "false") Boolean is_auto_create,
			@RequestParam(value = "isUpdate", required = false, defaultValue = "false") Boolean isUpdate,
			@RequestParam(value = "uuid", required = false, defaultValue = "-1") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				User user = new User();
				if (isUpdate) {
					user = userService.getUserById(id);
					user.setUsername(username);
					user.setEmail(email);
					String strSalt = Security.getSalt();
					user.setSalt(strSalt);
					user.setPassword(Security.encryptPassword(password.trim() + strSalt));
					user.setUser_type(user_type);
					user.setLogin_date(new Date());
					user.setActive(active);
					userService.updateUser(user);
					//
					result.setStatus(true);
					result.setMsg("Success. ");
					result.setData(user);
				} else {
					//check existed user
					if(!userService.checkExistUserName(username)){
						if(!userService.checkExistUserEmail(email)){
							user.setCreate_date(new Date());
							user.setUsername(username);
							user.setEmail(email);
							String strSalt = Security.getSalt();
							user.setSalt(strSalt);
							if(!is_auto_create){
								user.setPassword(Security.encryptPassword(password.trim() + strSalt));
							}else{
								user.setPassword(Security.encryptPassword(PASSWORD_DEFAULT + strSalt));
							}
							user.setUser_type(user_type);
							user.setLogin_date(new Date());
							user.setActive(active);
							userService.addUser(user);
							
							result.setStatus(true);
							result.setMsg("Success. ");
							result.setData(user);
						}else{
							result.setStatus(false);
							result.setMsg("Email unavailable . ");
						}
					}else{
						result.setStatus(false);
						result.setMsg("Username unavailable . ");
					}
				}
				return result;
			} catch (Exception e) {
				return result;
			}
		}
		return result;
	}

	@RequestMapping(value = "/viewUser.do/{id}", method = RequestMethod.GET)
	public ModelAndView viewUser(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load User
			User user = userService.getUserById(id);
			ModelAndView mv = null;
			if (user != null) {
				logger.info("Load User View Id: " + id);
				mv = new ModelAndView("user/show");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "View User");
				mv.addObject("PAGE_NAME", "View " + PAGE_NAME);

				Menu menu = new Menu(MENU.MANAGER, MENU_ITEM.MANAGER_USER);
				mv.addObject("MENU", menu);

				mv.addObject("USER", user);
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

	@RequestMapping(value = "/deleteUser.do", method = RequestMethod.GET)
	@ResponseBody
	public ResponseJson doDeleteUser(@RequestParam("id") String id,
			HttpSession session) {
		ResponseJson result = new ResponseJson();
		if (session.getAttribute("USERLOGIN") != null) {
			try {
				userService.removeUser(id);
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

	@RequestMapping(value = "/editUser.do/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable final String id,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("USERLOGIN") != null) {
			// Load User
			User user = userService.getUserById(id);
			ModelAndView mv = null;
			if (user != null) {
				logger.info("Load User Edit Id: " + id);
				mv = new ModelAndView("user/update");
				mv.addObject("URL", "../../resources/");
				mv.addObject("BASE_URL", "../../");

				mv.addObject("TITLE", "Edit User ");
				mv.addObject("PAGE_NAME", "Edit " + PAGE_NAME);

				mv.addObject("USER", user);
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
