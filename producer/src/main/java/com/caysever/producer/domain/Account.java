package com.caysever.producer.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private Long createdDate;
    private Long updatedDate;
    private String name;
    private String surname;
    private String gender;
    private String gsmNumber;
    private String identifier;
}