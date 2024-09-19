package com.heyBlossom.heyBlossom_project.service;

import com.heyBlossom.heyBlossom_project.controller.req.BlossomReqObj;
import com.heyBlossom.heyBlossom_project.domain.Blossom;
import com.heyBlossom.heyBlossom_project.dto.AggregateBlossomDto;
import com.heyBlossom.heyBlossom_project.entity.User;
import com.heyBlossom.heyBlossom_project.repository.BlossomRepository;
import com.heyBlossom.heyBlossom_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BlossomService {

    @Autowired
    private BlossomRepository blossomRepository;
    private UserRepository userRepository;

    public List<AggregateBlossomDto> findBlossomTop5() {
        // 1. 이번 달 1일부터 현재까지 모든 Blossom 데이터 조회
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfMonth = now.withDayOfMonth(1);
        List<Blossom> blossoms = blossomRepository.findByCreatedDateAfter(firstDayOfMonth);

        // 2. 반복문 돌며 giver 당 count 합계 계산
        Map<String, Long> blossomCountMap = new HashMap<>();
        for (Blossom blossom : blossoms) {
            User giver = blossom.getGiver();
            blossomCountMap.put(giver.getName(), blossomCountMap.getOrDefault(giver.getName(), 0L) + 1);
        }

        // 3. count가 많은 순으로 내림차순 정렬
        List<Map.Entry<String, Long>> sortedList = blossomCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .toList();

        // 4. 5개 데이터까지 잘라서 반환
        return sortedList.stream()
                .limit(5)
                .map(entry -> new AggregateBlossomDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public Blossom saveBlossom(BlossomReqObj blossomReqObj) throws Exception {
        // 1. giverName, receiverName으로 각각 User 객체 조회
        User giver = userRepository.findOneByUserName(blossomReqObj.getGiverName());
        User receiver = userRepository.findOneByUserName(blossomReqObj.getReceiverName());
        if (giver == null || receiver == null) {
            throw new Exception("giver or receiver is not exist.");
        }

        // 2. Blossom 객체 생성
        Blossom blossomObject = Blossom.builder()
                .giver(giver)
                .receiver(receiver)
                .message(blossomReqObj.getMessage())
                .build();

        // 3. Blossom 객체 데이터 저장
        return blossomRepository.save(blossomObject);
    }
}
