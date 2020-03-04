package com.cloudwastetracker.CloudWasteTracker.web;

import com.cloudwastetracker.CloudWasteTracker.vendor.Vendor;
import com.cloudwastetracker.CloudWasteTracker.vendor.VendorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class VendorsController {

	private VendorRepository vendorRepository;

	public VendorsController(VendorRepository vendorsRepository) {
		this.vendorRepository = vendorsRepository;
	}

	@RequestMapping("/vendors")
	public String vendors(Model model) {
		List<Vendor> vendors = this.vendorRepository.findAll();
		model.addAttribute("vendors", vendors);
		model.addAttribute("test", "test2");
		return "vendors";
	}
}
