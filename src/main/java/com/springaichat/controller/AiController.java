package com.springaichat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springaichat.service.AiService;

@RestController
@RequestMapping("/api/ai")
public class AiController {

	@Autowired
	AiService aiService;

	@GetMapping("/chat")
	public ResponseEntity<String> ask(@RequestParam String conversationId, @RequestParam String message) {
		return ResponseEntity.ok(aiService.chat(conversationId, message));
	}

}
