package com.springaichat.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiService {

	@Autowired
	ChatClient chatClient;

	public String chat(String conversationId, String message) {
		return chatClient.prompt().user(message).advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
				.call().content();
	}

}
