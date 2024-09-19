package com.heyBlossom.heyBlossom_project.dto;

import com.heyBlossom.heyBlossom_project.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
public class BlossomDto {

    private Long id;
    private String message;
    private User giver;
    private User receiver;

    @Builder
    public BlossomDto(Long id, String message, User giver, User receiver) {
        this.id = id;
        this.message = message;
        this.giver = giver;
        this.receiver = receiver;
    }
}
