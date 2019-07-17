package springBoot.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBoot.po.User;
import springBoot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(@RequestParam(value = "nickname",required = false) String nickname, Model model,
			@RequestParam(value = "curPage", required = false) Integer curPage) {
		System.out.println(nickname);
		if (nickname != null&&!nickname.equals("")) {
			int pageSize = 10;
			// 总数
			if (curPage == null || curPage < 1) {
				
				return "redirect:/index?curPage=1&nickname="+URLEncoder.encode(nickname);
				
			}
			int totalRows = userService.getUserByTotal(nickname);
			// 分页情况
						int totalPages = totalRows / pageSize;
						// 有余数
						int left = totalRows % pageSize;
						if (left > 0) {
							totalPages = totalPages + 1;
						}
						if (curPage > totalPages) {
							curPage = totalPages;
						}

						// 行数
						int startRow = (curPage - 1) * pageSize;
						Map<String, Object> paramMap = new ConcurrentHashMap<>();
						paramMap.put("startRow", startRow);
						paramMap.put("pageSize", pageSize);
						paramMap.put("nickname", nickname);
						
						List<User> userList = userService.getUserByPage2(paramMap);
						model.addAttribute("userList", userList);
						model.addAttribute("curPage", curPage);
						model.addAttribute("totalPages", totalPages);
		} else {

			int pageSize = 10;
			if (curPage == null || curPage < 1) {
				return "redirect:/index?curPage=1";
			}

			// 总数
			int totalRows = userService.getUserByTotal();
			// 分页情况
			int totalPages = totalRows / pageSize;
			// 有余数
			int left = totalRows % pageSize;
			if (left > 0) {
				totalPages = totalPages + 1;
			}
			if (curPage > totalPages) {
				curPage = totalPages;
			}

			// 行数
			int startRow = (curPage - 1) * pageSize;
			Map<String, Object> paramMap = new ConcurrentHashMap<>();
			paramMap.put("startRow", startRow);
			paramMap.put("pageSize", pageSize);
			List<User> userList = userService.getUserByPage(paramMap);
			model.addAttribute("userList", userList);
			model.addAttribute("curPage", curPage);
			model.addAttribute("totalPages", totalPages);
		}
		return "index";
	}

	// 去到添加页面&修改页面
	@RequestMapping("/user/toAddUser")
	public String toAddUser() {
		return "addUser";
	}

	// 添加用户，springboot可以直接嵌入user
	@RequestMapping("/user/addUser")
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/index";
	}

	// 去到修改用户页面
	@RequestMapping("/user/toUpdate")
	public String toUpdateUser(Model model, @RequestParam("id") Integer id) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "updateUser";
	}

	@RequestMapping("/user/updateUser")
	public String updateUser(User user) {
		userService.updateUser(user);
		return "redirect:/index";
	}

	// 删除用户
	@RequestMapping("/user/delete")
	public String delete(@RequestParam("id") Integer id) {
		userService.deleteUser(id);
		return "redirect:/index";
	}

//	@RequestMapping(value = "/queryByCon", method = RequestMethod.POST)
//	@ResponseBody
//    public  List<User> queryByCon(@RequestBody User user) 
//	 {
//		 List<User> stu = new ArrayList<User>();
//    	 stu = userService.findOrdersByCon(user.getUsername());
//		 return stu;
//	 }

}
