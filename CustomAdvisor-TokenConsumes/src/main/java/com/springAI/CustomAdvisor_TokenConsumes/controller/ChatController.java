package com.springAI.CustomAdvisor_TokenConsumes.controller;

import com.springAI.CustomAdvisor_TokenConsumes.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    private ChatService chatService;

    public ChatController(ChatService chatService) {

        this.chatService = chatService;
    }


    @GetMapping("/chat")
    public ResponseEntity<String> chatTemplate(@RequestParam(value = "q", required = true)String q) {

        log.info("Question: {}, Answer: {}",q,chatService.chatTemplate(q));
        return ResponseEntity.ok(chatService.chatTemplate(q));
    }
}
