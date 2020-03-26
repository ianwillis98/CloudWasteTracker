package com.cloudwastetracker.CloudWasteTracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GraphController {
	
	
	@RequestMapping("graph")

	public String home() {
		return "graph";
	}
}
