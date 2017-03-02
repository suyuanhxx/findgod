package com.findgods.fly.controller;

import com.findgods.fly.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * REVIEW
 * @Description:
 * @author xiaoxu.huang
 * @date 2017/2/24  16:58
 *
 */
@Controller
public class SampleController {

	@RequestMapping("/")
	public String home() {
		return "html/index";
	}

	@RequestMapping("/index")
	ModelAndView index() {
		return new ModelAndView("index.html");
	}

	@RequestMapping("/user/{id}")
	@ResponseBody
	User index(@PathVariable("id") Long id) {
		User user = new User();
		user.setId(1233L);
		user.setUsername("sfasdf");
		return user;
	}

}
