package com.shingle.ai.controller;


import com.shingle.ai.service.SpringAiService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/open-ai")
@RestController
public class SpringAiController {

    @Resource
    private SpringAiService springAiService;


    @GetMapping("/send")
    public Object sendMessage(Map<String, String> content) {
        return springAiService.sendMessage(content);
    }
}
