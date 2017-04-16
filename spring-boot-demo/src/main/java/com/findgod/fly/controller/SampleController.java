package com.findgod.fly.controller;

import org.springframework.stereotype.Controller;
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
	@ResponseBody
	public String home() {
		return "index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

}
