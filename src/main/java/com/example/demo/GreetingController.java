package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final MyService myService;

    @Autowired
    public GreetingController(MyService myService)
    {
        this.myService = myService;    	
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	this.myService.doSomethingAmazing();
        return new Greeting(String.format(template, name));
    }
}