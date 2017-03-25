package com.vine.blog.domain.entity.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vine.blog.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "authorizations", indexes = {
        @Index(name = "idx_authorizations_provider_uid", columnList = "provider,uid")
})
public class Authorization extends BaseEntity {
    private String uid;
    private String nickname;

    @Column(length = 10000)
    private String biography;

    private String avatar;
    private String token;
    private Integer expiresIn;
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    private Provider provider;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;

    public Authorization() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public enum Provider {
        CAS("内网"),
        WEIBO("新浪微博"),
        QQ("腾讯QQ"),
        DOUBAN("豆瓣"),
        WECHAT("微信"),
        FACEBOOK("Facebook"),
        TWITTER("Twitter");

        private String title;

        Provider(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return this.title;
        }

        public static List<Provider> all() {
            return Arrays.asList(WEIBO, QQ, DOUBAN, WECHAT, FACEBOOK, TWITTER);
        }
    }
}
