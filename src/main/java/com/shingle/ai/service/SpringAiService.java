package com.shingle.ai.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class SpringAiService {
    private final ChatClient chatClient;

    public SpringAiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public Object sendMessage(Map<String, String> content) {
        if (MapUtils.isEmpty(content)) {
            return "请输入内容";
        }
        String message = content.get("message");
        if (StringUtils.isBlank(message)) {
            return "请输入内容";
        }
        ChatClient.ChatClientRequest chatClientRequest = chatClient.prompt().user(message);
        ChatClient.ChatClientRequest.CallResponseSpec callResponseSpec = chatClientRequest.call();
        ChatResponse chatResponse = callResponseSpec.chatResponse();
        log.info("sendMessage response: {}", chatResponse);
        return callResponseSpec.content();
    }
}
