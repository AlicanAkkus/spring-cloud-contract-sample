package com.caysever.consumer.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private String name;
    private String surname;
    private String gender;
    private String gsmNumber;
    private String identifier;
    private Long createdDate;
    private Long updatedDate;
}