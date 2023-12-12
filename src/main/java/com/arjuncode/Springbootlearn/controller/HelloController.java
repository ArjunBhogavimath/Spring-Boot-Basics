package com.arjuncode.Springbootlearn.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Component
//@Controller // this @Controller annotation internally calls @Component annotation so we can remove @Component
@RestController // we need this to be rest controller so it will always return a response body
/* it will do 2 things
1. it will by default a controller
2. It will always return response body
*/
public class HelloController {

    // "8080/" will be execute this

    //@RequestMapping(value = "/",method = RequestMethod.GET)
    //different types of reuqests will be there
    // i.e., GET , POST, DELETE, OPTIONS
    // so instead of @RequestMapping we can direcly use @GetMapping directly

    @GetMapping("/")
    public String helloWorld(){
        return "WELCOME TO LEARN SPRING BOOT ARJUN!!!";
    }
}
