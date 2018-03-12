package com.nwm.springbootweb.mvc;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecordMvcController {
	
	@GetMapping("/whatever")
	public String index(Model model) {
		model.addAttribute("currentTimestamp", new Date().toString());
		return "whatever";
	}
}