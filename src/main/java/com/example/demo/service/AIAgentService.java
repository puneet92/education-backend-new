package com.example.demo.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIAgentService {

    private final ChatClient chatClient;

    @Autowired(required = false)
    public AIAgentService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String chat(String userMessage) {
        try {
            Prompt prompt = new Prompt(new UserMessage(userMessage));
            ChatResponse response = chatClient.call(prompt);
            return response.getResult().getOutput().getContent();
        } catch (Exception e) {
            return "Error communicating with Ollama: " + e.getMessage() +
                   ". Make sure Ollama is running with: brew services start ollama";
        }
    }

    public String helloWorldAgent() {
        return chat("Say 'Hello World' in a friendly way!");
    }
}
