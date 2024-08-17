package com.heyBlossom.heyBlossom_project.dto;

import com.heyBlossom.heyBlossom_project.entity.User;
import lombok.Data;

@Data
public class BlossomDto {
    private Long id;
    private String description;
    private User fromUser;
    private User toUser;
}
