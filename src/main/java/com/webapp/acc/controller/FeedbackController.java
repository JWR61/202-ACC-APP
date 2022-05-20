package com.webapp.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.webapp.acc.entity.Feedback;

import com.webapp.acc.service.FeedbackService;

@Controller
public class FeedbackController {


@Autowired
private FeedbackService feedservice;

	@GetMapping("/newFeedback")
	public String newFeedback(Model model) {
		Feedback feedback = new Feedback();
	    model.addAttribute("f", feedback);
		return "feedback";
	}
	
	@PostMapping("/saveFeedback")
	public String saveFeedback(@ModelAttribute("f") Feedback feedback) {
		feedservice.saveFeedback(feedback);
		return "thanks";
	}
	
	
}
