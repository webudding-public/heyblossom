package com.heyBlossom.heyBlossom_project.controller;

import com.heyBlossom.heyBlossom_project.dto.AggregateBlossomDto;
import com.heyBlossom.heyBlossom_project.service.BlossomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlossomController {

    private final BlossomService blossomService;

    // 의존성 생성자 주입
    public BlossomController(BlossomService blossomService) {
        this.blossomService = blossomService;
    }

    @GetMapping("/find-top5")
    public List<AggregateBlossomDto> aggregateBlossom() {
        return this.blossomService.findBlossomTop5();
    }
}
