package com.example.aop_demo.web;


import com.example.aop_demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final DemoService demoService;

    public TestController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/test/time")
    public String test() throws InterruptedException {
        return demoService.slowOperation();
    }
}
