package org.prathyusha.menteemanagementsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MenteeMgmtSystemController {
    
    @GetMapping('/')
    public String sayHello() {
        return "Hello there!!";
    }
}