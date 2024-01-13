package com.TransfertNational.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    @GetMapping("/server")
    public String turnOnServer(){
        return "Done";
    }
}
