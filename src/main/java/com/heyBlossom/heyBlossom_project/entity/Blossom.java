package com.heyBlossom.heyBlossom_project.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Blossoms")
public class Blossom extends BaseEntity {

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "blossom")
    private Set<UserBlossom> userBlossoms;
}
