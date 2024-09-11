package com.kh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.entity.Hamburger;
import com.kh.service.HServcie;

import java.util.List;
@Controller
public class HController {
	
	@Autowired
	private HServcie hServcie;
	
	@GetMapping("/api/all")
	public String getAll(Model m) {
		List<Hamburger> h = hServcie.getAll();
		m.addAttribute("ham", h);
		return "hambugerList"; // src/main/webapp/WEB-INF/jsp/hambugerList.jsp 가져오기
	}
	
	@PostMapping("/api/add")
	public String addHamburger(Hamburger h) {
		hServcie.saveHamburger(h);
		return "redirect:/hambugerList";
	}
}






