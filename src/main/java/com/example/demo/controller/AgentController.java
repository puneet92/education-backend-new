package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AIAgentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/agent")
public class AgentController {

    @Autowired
    private AIAgentService aiAgentService;

    @GetMapping("/hello")
    public String helloWorldAgent() {
        return aiAgentService.helloWorldAgent();
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request) {
        return aiAgentService.chat(request.getMessage());
    }

    // Inner class for request body
    public static class ChatRequest {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
