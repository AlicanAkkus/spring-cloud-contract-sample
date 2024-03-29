package com.caysever.consumer.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountSettings {

    private Long accountId;
    private String name;
    private String surname;
    private boolean verified;
    private boolean pushNotificationEnabled;
    private Long createdDate;
    private Long updatedDate;
}