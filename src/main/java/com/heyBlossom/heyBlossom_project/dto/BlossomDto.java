package com.heyBlossom.heyBlossom_project.dto;

import com.heyBlossom.heyBlossom_project.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
public class BlossomDto {

    private Long id;
    private String description;
    private User fromUser;
    private User toUser;

    @Builder
    public BlossomDto(Long id, String description, User fromUser, User toUser) {
        this.id = id;
        this.description = description;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }
}
