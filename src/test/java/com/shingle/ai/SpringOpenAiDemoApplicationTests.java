package com.shingle.ai;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringOpenAiDemoApplicationTests {

    @Resource
    private ChatClient chatClient;

    @Test
    void sayHello() {

        ChatResponse chatResponse = sendMessage("Hello OpenAi!");
        Gson gson = new Gson();
        System.out.println("========================");
        System.out.println(gson.toJson(chatResponse.getResults()));
    }

    @Test
    void draw() {

        ChatResponse chatResponse = sendMessage("please draw a man like Elon Musk");
        System.out.println("========================");
        System.out.println(chatResponse.getResults());
    }

    private ChatResponse sendMessage(String message) {
        ChatClient.ChatClientRequest chatClientRequest = chatClient.prompt().user(message);
        ChatClient.ChatClientRequest.CallResponseSpec callResponseSpec = chatClientRequest.call();
        ChatResponse chatResponse = callResponseSpec.chatResponse();
        return chatResponse;
    }

}
