package com.heyBlossom.heyBlossom_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "User-Blossom")
public class UserBlossom extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;

    @ManyToOne
    @JoinColumn(name = "blossom_id")
    private Blossom blossom;
}
