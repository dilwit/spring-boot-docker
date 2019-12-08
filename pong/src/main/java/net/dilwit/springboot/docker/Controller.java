package net.dilwit.springboot.docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/pong")
    public String getPong() {

        StringBuilder message = new StringBuilder();
        message.append("PONG");

        return message.toString();
    }
}
