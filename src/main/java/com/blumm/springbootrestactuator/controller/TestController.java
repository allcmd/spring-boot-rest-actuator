package com.blumm.springbootrestactuator.controller;

import com.blumm.springbootrestactuator.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class TestController {

    private final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/test")
    @ResponseBody
    public Greeting test(@RequestParam(name = "name", required = false, defaultValue = "Anonymous") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
