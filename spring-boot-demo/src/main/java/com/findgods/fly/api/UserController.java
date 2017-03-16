package com.findgods.fly.api;

import com.findgods.fly.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * REVIEW @RestController  注解相当于 @Controller 和 @ResponseBody
 * @Description: restful api
 * @author xiaoxu.huang
 * @date 2017/3/2  10:33
 *
 */
@RestController
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	public String getUserByUsername(@PathVariable String username) {
		userService.find(username);
		return "success";
	}

	@RequestMapping(value = "/user/{username}", method = RequestMethod.POST)
	public String updateUserByUsername(@PathVariable String username) {
		userService.save(username);
		return "success";
	}

}
