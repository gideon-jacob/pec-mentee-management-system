package org.prathyusha.menteemanagementsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class MenteeManagementSystemController {
    
    @GetMapping("/")
    public String sayHello() {
        return "Hello there!!";
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello from API!";
    }
}