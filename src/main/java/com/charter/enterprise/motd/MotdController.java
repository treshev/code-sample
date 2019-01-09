package com.charter.enterprise.motd;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class MotdController {

    private String messageOfTheDay = "Did I pass the test.";

    @GetMapping
    public String getMotd() {
        return messageOfTheDay;
    }

    @PutMapping("/updateMessage")
    public String updateMessageFromPutRequest(@RequestParam String newMessageOfTheDay) {
        messageOfTheDay = newMessageOfTheDay;
        return "Message was successfully changed from PUT request to: " + newMessageOfTheDay;
    }

    @GetMapping("/updateMessage")
    public String updateMessageFromGetRequest(@RequestParam String newMessageOfTheDay) {
        messageOfTheDay = newMessageOfTheDay;
        return "Message was successfully changed from GET request to: " + newMessageOfTheDay;
    }
}
