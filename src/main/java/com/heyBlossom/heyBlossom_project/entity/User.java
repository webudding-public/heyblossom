package com.heyBlossom.heyBlossom_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "User")
public class User extends BaseEntity {

    private String name;

    private String nickname;

    private int status;

    @OneToMany(mappedBy = "fromUser")
    private Set<UserBlossom> sentBlossoms;

    @OneToMany(mappedBy = "toUser")
    private Set<UserBlossom> receivedBlossoms;
}
