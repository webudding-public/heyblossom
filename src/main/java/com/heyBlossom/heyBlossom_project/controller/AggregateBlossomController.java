package com.heyBlossom.heyBlossom_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AggregateBlossomController {
    @GetMapping("/")
    public String aggregateBlossom() {
        return "aggregateBlossom data";
    }
}
