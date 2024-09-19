package com.heyBlossom.heyBlossom_project.domain;

import com.heyBlossom.heyBlossom_project.entity.User;
import lombok.Getter;

@Getter
public class Blossom {

    private Long id;
    private String message;
    private User giver;
    private User receiver;
}
