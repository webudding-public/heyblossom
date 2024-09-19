package com.heyBlossom.heyBlossom_project.dto;

import lombok.Data;

@Data
public class AggregateBlossomDto {

    private String receiver;
    private Number getBlossoms;

    public AggregateBlossomDto(String receiver, Number getBlossoms) {
        this.receiver = receiver;
        this.getBlossoms = getBlossoms;
    }
}
