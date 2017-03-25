package com.vine.blog.domain.entity.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.vine.blog.domain.entity.BaseEntity;
import com.vine.blog.domain.entity.catalog.Category;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    @OneToOne
    @JsonIgnore
    private Content content;

//    @OneToOne
//    private Account account;

    @OneToOne
    @JsonIgnore
    private Category category;

    @JsonIgnore
    @ElementCollection
    private Set<String> tags = new HashSet<String>();

    @JsonIgnore
    @Column(nullable = false, columnDefinition = "BOOLEAN default 0")
    private Boolean reply;

    @JsonIgnore
    @Column(nullable = false, columnDefinition = "BOOLEAN default 0")
    private Boolean highlight = false;

    @JsonIgnore
    @Column(nullable = false, columnDefinition = "BOOLEAN default 0")
    private Boolean recommend =false;

    @JsonIgnore
    @Column(nullable = false, columnDefinition = "BOOLEAN default 0")
    private Boolean stick = false;

    @JsonIgnore
    @Column(nullable = false, columnDefinition = "BOOLEAN default 0")
    private Boolean featured = false;

    @JsonView(Summary.class)
    @Enumerated(EnumType.STRING)
    private PostStatus status = PostStatus.DRAFT;

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Boolean getReply() {
        return reply;
    }

    public void setReply(Boolean reply) {
        this.reply = reply;
    }

    public Boolean getHighlight() {
        return highlight;
    }

    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getStick() {
        return stick;
    }

    public void setStick(Boolean stick) {
        this.stick = stick;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content=" + content +
                ", category=" + category +
                ", tags=" + tags +
                ", reply=" + reply +
                ", highlight=" + highlight +
                ", recommend=" + recommend +
                ", stick=" + stick +
                ", featured=" + featured +
                ", status=" + status +
                '}';
    }

    public enum PostStatus {
        DRAFT, PUBLISHED;
        public static List<PostStatus> all() {
            return Arrays.asList(DRAFT, PUBLISHED);
        }
    }
}
