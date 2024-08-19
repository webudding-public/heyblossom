package com.heyBlossom.heyBlossom_project.dto;

import lombok.Data;

@Data
public class AggregateBlossomDto {

    private String toUserName;
    private Number getBlossoms;

    public AggregateBlossomDto(String toUserName, Number getBlossoms) {
        this.toUserName = toUserName;
        this.getBlossoms = getBlossoms;
    }
}
