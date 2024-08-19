package com.heyBlossom.heyBlossom_project.service;

import com.heyBlossom.heyBlossom_project.dto.AggregateBlossomDto;
import com.heyBlossom.heyBlossom_project.repository.BlossomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlossomService {

    private final BlossomRepository blossomRepository;

    public BlossomService(BlossomRepository blossomRepository) {
        this.blossomRepository = blossomRepository;
    }

    public List<AggregateBlossomDto> findBestBlossomTop5() {
        // 1. 이번 달 1일부터 현재까지 모든 Blossom 데이터 조회
        // 2. 반복문 돌며 toUser 당 count 합계 계산
        // 3. count가 많은 순으로 내림차순 정렬
        // 4. 5개 데이터까지 잘라서 반환
    }
}
