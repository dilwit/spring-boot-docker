package net.dilwit.springboot.docker.ping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Autowired
    RestTemplate restTemplate;

    @Value("${service.pong.url}")
    private String pongUrl;

    @RequestMapping("/")
    public String home() {

        logger.info("request for / is received");
        StringBuilder message = new StringBuilder();
        message.append("Hello Docker - PING").append("\n")
                .append("Active profile: ").append(activeProfile).append("\n");

        return message.toString();
    }

    @RequestMapping("/ping")
    public String getPing() {

        logger.info("request for /ping is received");
        StringBuilder message = new StringBuilder();
        message.append("PING");

        return message.toString();
    }

    @RequestMapping("/pingPong")
    public String getPingPong() {

        logger.info("request for /pingPong is received");
        StringBuilder message = new StringBuilder();
        message.append(getPing());

        ResponseEntity<String> response = restTemplate.getForEntity(pongUrl, String.class);
        message.append(response.getBody());

        return message.toString();
    }
}
