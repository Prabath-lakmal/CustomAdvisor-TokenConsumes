package com.springAI.CustomAdvisor_TokenConsumes.config;

import com.springAI.CustomAdvisor_TokenConsumes.advisors.TokenPrintAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){
        return builder
                .defaultAdvisors(new TokenPrintAdvisor(),new SimpleLoggerAdvisor(), new SafeGuardAdvisor(List.of("games")))
//                .defaultSystem("As an expert in coding")
                .defaultOptions(GoogleGenAiChatOptions.builder()
                        .model("gemini-3.6-flash")
                        .temperature(0.7)
                        .maxTokens(100000))
                .build();
    }
}
