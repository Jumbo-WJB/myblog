package com.vine.blog.domain.entity.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vine.blog.domain.entity.BaseEntity;
import com.vine.blog.domain.entity.serializer.EmailAddressJsonSerializer;
import com.vine.blog.domain.entity.serializer.PhotoJsonSerializer;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts", indexes = {
        @Index(name = "idx_accounts_email", columnList = "email", unique = true),
        @Index(name = "idx_accounts_phone", columnList = "phone", unique = true),
        @Index(name = "idx_accounts_device_token", columnList = "deviceToken", unique = true)
})
public class Account extends BaseEntity {

    @JsonView(Summary.class)
    private String nickname;

    @JsonView(Private.class)
    private EmailAddress email = null;

    @JsonView(Private.class)
    private String phone = null;

    @JsonIgnore
    private String password;

    @JsonView(Summary.class)
    private String avatar;

    @JsonIgnore
    private String deviceToken;

    @JsonIgnore
    @Column(length = 500)
    private String note;

    @JsonIgnore
    @ElementCollection
    private Set<String> tags = new HashSet<String>();

    @JsonIgnore
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Authorization> authorizations = new HashSet<Authorization>();

    @JsonIgnore
    @Column(nullable = false, columnDefinition = "BOOLEAN default 0")
    private boolean blocked = false;

    @JsonIgnore
    private String userAgent = "";

    @JsonView(Summary.class)
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.FEMALE;

    @JsonView(Summary.class)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    public Account() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonSerialize(using = EmailAddressJsonSerializer.class)
    public EmailAddress getEmail() {
        return email;
    }

    public void setEmail(EmailAddress email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonSerialize(using= PhotoJsonSerializer.class)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Set<Authorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(Set<Authorization> authorizations) {
        this.authorizations = authorizations;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public enum Gender {
        FEMALE, MALE
    }

    public enum Role {
        USER("普通用户"), AGENT("客服人员"), ADMIN("管理员");

        private final String title;

        Role(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    @Override
    public String toString() {
        if (!StringUtils.isEmpty(nickname)) return nickname;
        if (!StringUtils.isEmpty(email)) return email.toString();

        return "Account (" + getId() + ")";
    }
}
