package org.example.chatbot.web;

/**
 * @author achraf
 * @date 12/24/25
 *
 */

import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private OpenAiChatClient openAiChatClient;

    @Autowired
    private OllamaChatClient ollamaChatClient;

    @PostMapping("/openai")
    public String chatWithOpenAI(@RequestBody String prompt) {
        return openAiChatClient.call(prompt);
    }

    @PostMapping("/ollama")
    public String chatWithOllama(@RequestBody String prompt) {
        return ollamaChatClient.call(prompt);
    }
}