package com.heyBlossom.heyBlossom_project.controller;

import com.heyBlossom.heyBlossom_project.controller.req.BlossomReqObj;
import com.heyBlossom.heyBlossom_project.domain.Blossom;
import com.heyBlossom.heyBlossom_project.dto.AggregateBlossomDto;
import com.heyBlossom.heyBlossom_project.service.BlossomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
        return blossomService.findBlossomTop5();
    }

    @GetMapping("/give-blossom")
    public Blossom saveBlossom(@RequestBody BlossomReqObj blossomReqObj) throws Exception {
        return blossomService.saveBlossom(blossomReqObj);
    }
}
