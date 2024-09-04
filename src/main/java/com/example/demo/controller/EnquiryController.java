package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.ViewEnqFilterRequest;
import com.example.demo.entity.Enquiry;
import com.example.demo.service.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnquiryController {

	private EnquiryService enqService;

	public EnquiryController(EnquiryService enqService) {
		super();
		this.enqService = enqService;
	}

	/*
	 * public String getEnquiries(ViewEnqFilterRequest viewEnqFilterRequest,
	 * HttpServletRequest req1, Model model) { HttpSession session =
	 * req1.getSession(false); Integer counsellorId = (Integer)
	 * session.getAttribute("counsellorId"); List<Enquiry> enqList =
	 * enqService.getAllEnquiries(counsellorId); model.addAttribute("enquiries",
	 * enqList);
	 * 
	 * ViewEnqFilterRequest filterReq = new ViewEnqFilterRequest(); return
	 * "viewEnqsPage";
	 * 
	 * }
	 */

	@GetMapping("/enquiry")
	public String addEnquiryPage(Model model) {

		Enquiry enqObj = new Enquiry();
		model.addAttribute("enq", enqObj);
		return "enquiryForm";

	}

	@PostMapping("/addEnquiry")
	public String handleAddEnquiryPage(Enquiry enq, HttpServletRequest req, Model model) throws Exception {
		System.out.println("here handleAddEnquiryPage ");
		HttpSession session = req.getSession(false);

		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		System.out.println("here counsellorId " + counsellorId);
		boolean isSaved = enqService.addEnquiry(enq, counsellorId);
//	if (counsellorId != null) {
		if (isSaved) {
			model.addAttribute("smsg", "enquiry added");
		} else {
			model.addAttribute("emsg", "enquiry failed");
		}
		Enquiry enqObj = new Enquiry();
		model.addAttribute("enq", enqObj);
		// }
		// else {
		// model.addAttribute("emsg", "Counsellor ID cannot be null.");
		// }
		return "enquiryForm";
	}

	/*
	 * @GetMapping("view-enquiries") public String getMethodName(@RequestParam
	 * String param) { return new String(); }
	 */

	/*
	 * public String getEnquiries(HttpServletRequest req, Model model) { return
	 * "viewEnqsPage"; }
	 */

	@GetMapping("/viewenquiry")
	public String getEnquiries(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		List<Enquiry> enqList = enqService.getAllEnquiries(counsellorId);
		model.addAttribute("enquiries", enqList);

		ViewEnqFilterRequest viewEnqFilterRequest = new ViewEnqFilterRequest();
		model.addAttribute("viewEnqFilterRequest", viewEnqFilterRequest);
		return "viewEnqsPage";
	}

	@PostMapping("/filter-enqs")
	public String filterEnquiries(ViewEnqFilterRequest viewEnqFilterRequest, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		List<Enquiry> enqList = enqService.getEnquiriesWithFilter(viewEnqFilterRequest, counsellorId);
		model.addAttribute("enquiries", enqList);
		return "viewEnqsPage";
	}

	@GetMapping("/editEnq")
	public String editEnquiry(@RequestParam("enqId") Integer enqId, Model model) {
		Enquiry enquiry = enqService.getEnquiryById(enqId);
		model.addAttribute("enq", enquiry);
		return "enquiryForm";
	}

}
