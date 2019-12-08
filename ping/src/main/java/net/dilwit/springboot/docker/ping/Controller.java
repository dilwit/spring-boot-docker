package net.dilwit.springboot.docker.ping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Autowired
    RestTemplate restTemplate;

    @Value("${service.pong.url}")
    private String pongUrl;

    @RequestMapping("/")
    public String home() {

        StringBuilder message = new StringBuilder();
        message.append("Hello Docker - PING").append("\n")
                .append("Active profile: ").append(activeProfile).append("\n");

        return message.toString();
    }

    @RequestMapping("/ping")
    public String getPing() {

        StringBuilder message = new StringBuilder();
        message.append("PING");

        return message.toString();
    }

    @RequestMapping("/pingPong")
    public String getPingPong() {

        StringBuilder message = new StringBuilder();
        message.append(getPing());

        ResponseEntity<String> response = restTemplate.getForEntity(pongUrl, String.class);
        message.append(response.getBody());

        return message.toString();
    }
}
