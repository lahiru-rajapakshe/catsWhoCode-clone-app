package online.lahiru.sprinngbotrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringConntoller {
    @GetMapping("/hello")
    public  String HelloWworld(){
        return "Hello world llaahiru";
    }
}
