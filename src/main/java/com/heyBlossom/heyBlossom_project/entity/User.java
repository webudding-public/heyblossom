package com.heyBlossom.heyBlossom_project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    private Integer status;

    @Column(nullable = false )
    @ColumnDefault("0")
    private Integer givenCount;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer receivedCount;
}
