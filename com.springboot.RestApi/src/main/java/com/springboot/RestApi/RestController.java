package com.springboot.RestApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String run()
	{
		return "I am running";
	}

}
