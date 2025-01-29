package fr.efrei.spring.rag.web.rest;

import fr.efrei.spring.rag.service.AssistantAiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssisstantAIResource {

    private final Logger log = LoggerFactory.getLogger(AssisstantAIResource.class);
    private final AssistantAiService assistantAiService;

    public AssisstantAIResource(AssistantAiService assistantAiService) {
        this.assistantAiService = assistantAiService;
    }

    @PostMapping("/assisstant/chat")
    public String chat(@RequestBody String query) {
        log.debug("Received request to chat with {}", query);
        return assistantAiService.chat(query);
    }

}
