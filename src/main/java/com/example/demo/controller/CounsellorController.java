package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.DashboardResponse;
import com.example.demo.entity.Counsellor;
import com.example.demo.service.CounsellorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {

	private CounsellorService counsellorService;

	public CounsellorController(CounsellorService counsellorService) {
		super();
		this.counsellorService = counsellorService;
	}

	@GetMapping("/")
	public String index(Model model) {

		Counsellor cobj = new Counsellor();

		model.addAttribute("counsellor", cobj);
		return "index";
	}

	@PostMapping("/login")
	public String handleLoginBtn(Counsellor counsellor, HttpServletRequest request, Model model) {
		Counsellor c = counsellorService.login(counsellor.getEmail(), counsellor.getPwd());

		if (c == null) {
			model.addAttribute("emsg", "invalid credentials");
			return "index";
		} else {

			// valid login store counsellor id in session
			 HttpSession session = request.getSession();
			session.setAttribute("counsellorId", c.getCounsellorId());
			DashboardResponse dbresobj = counsellorService.getDashboardInfo(c.getCounsellorId());
			model.addAttribute("dashboardInfo", dbresobj);
			return "dashboard";
		}
		// return "";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {

		Counsellor cobj = new Counsellor();
		model.addAttribute("counsellor", cobj);
		return "register";
	}

	@PostMapping("/register")
	public String handleReistration(@ModelAttribute Counsellor counsellor, Model model) {

		// counsellorService.findByEmail(counsellor.getEmail());
		boolean isRegister = counsellorService.register(counsellor);

		if (isRegister) {
			model.addAttribute("smsg", "registration success");
		} else {
			model.addAttribute("emsg", "registration fails");
		}
		return "register";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session!=null) {
		session.invalidate();
		}
		return "redirect:/";

	}
}
