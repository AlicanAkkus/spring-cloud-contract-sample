package com.caysever.consumer.domain;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_settings")
@EntityListeners(AuditingEntityListener.class)
public class AccountSettingsEntity {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedDate;

    @Type(type = "numeric_boolean")
    @Column(name = "push_notification_enabled", nullable = false)
    private boolean pushNotificationEnabled;

    @Type(type = "numeric_boolean")
    @Column(name = "verified", nullable = false)
    private boolean verified;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isPushNotificationEnabled() {
        return pushNotificationEnabled;
    }

    public void setPushNotificationEnabled(boolean pushNotificationEnabled) {
        this.pushNotificationEnabled = pushNotificationEnabled;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "AccountSettingsEntity{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", pushNotificationEnabled=" + pushNotificationEnabled +
                ", verified=" + verified +
                ", accountId=" + accountId +
                '}';
    }
}