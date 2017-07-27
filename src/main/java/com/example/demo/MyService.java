package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final CounterService counterService;
    private final GaugeService gaugeService;

    @Autowired
    public MyService(CounterService counterService, GaugeService gaugeService) {
        this.counterService = counterService;
        this.gaugeService = gaugeService;
    }

    public void doSomethingAmazing() {
        this.counterService.increment("services.system.myservice.invoked");
        this.gaugeService.submit("services.system.myservice.guage", System.currentTimeMillis());
    }

}