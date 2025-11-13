package com.example.aop_demo.service;


import com.example.aop_demo.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @LogExecutionTime
    public String slowOperation() throws InterruptedException {
        Thread.sleep(1500);
        return "Done!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    }
}
