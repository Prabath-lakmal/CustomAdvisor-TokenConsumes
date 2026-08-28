package com.springAI.CustomAdvisor_TokenConsumes.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatClient chatClient;

    @Value("classpath:/prompts/user-message.st")
    private Resource userMessage;

    @Value("classpath:/prompts/system-message.st")
    private Resource systemMessage;

    public  ChatServiceImpl(ChatClient chatClient){

        this.chatClient = chatClient;
    }


        public String chatTemplate(String query){

            return this.chatClient
                    .prompt()
                    .advisors(new SimpleLoggerAdvisor())
                    .system(system-> system.text(this.systemMessage))
                    .user(user->
                            user.text(this.userMessage).param("concept", query))
                            .call()
                            .content();
        }

}
