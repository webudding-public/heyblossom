package com.heyBlossom.heyBlossom_project.domain;

import com.heyBlossom.heyBlossom_project.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Blossom {

    private Long id;
    private String description;
    private User fromUser;
    private User toUser;
}
