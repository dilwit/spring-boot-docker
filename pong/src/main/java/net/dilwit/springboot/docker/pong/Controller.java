package net.dilwit.springboot.docker.pong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @RequestMapping("/")
    public String home() {

        logger.info("request for / is received");
        StringBuilder message = new StringBuilder();
        message.append("Hello Docker - PONG").append("\n")
                .append("Active profile: ").append(activeProfile).append("\n");

        return message.toString();
    }

    @RequestMapping("/pong")
    public String getPong() {

        logger.info("request for /pong is received");
        StringBuilder message = new StringBuilder();
        message.append("PONG");

        return message.toString();
    }
}
