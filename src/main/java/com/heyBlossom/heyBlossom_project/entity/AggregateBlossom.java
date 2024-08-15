package com.heyBlossom.heyBlossom_project.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "AggregateBlossom")
public class AggregateBlossom extends BaseEntity {

    private String week;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}