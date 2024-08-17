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
@Table(name = "Users")
public class User extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nick_name", nullable = false)
    private String nickname;

    @Column(name = "status", nullable = false)
    private int status;

    @OneToMany(mappedBy = "fromUser")
    private Set<UserBlossom> sentBlossoms;

    @OneToMany(mappedBy = "toUser")
    private Set<UserBlossom> receivedBlossoms;
}
