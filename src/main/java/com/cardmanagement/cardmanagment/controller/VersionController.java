package com.cardmanagement.cardmanagment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
    
    @Value("${app.version}")
    String projectVersion;

    @GetMapping("/_version")
    public String getVersion() {
        return "hello this is my version " + projectVersion;
    }

}
