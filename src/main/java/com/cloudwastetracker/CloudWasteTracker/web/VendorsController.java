package com.cloudwastetracker.CloudWasteTracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class VendorsController {
	
	
	@RequestMapping("vendor")

	public String vendors(Model model) {
		model.addAttribute("name", "test name");
		
		return "vendors";
	}
}
