package com.roomies.roomies.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="reviews")
public class Review extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Lob
    private String content;

    @NotNull
    private int starQuantity;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="post_id",nullable = false)
    @JsonIgnore
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="user_id",nullable = false)
    @JsonIgnore
    private User user;

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public Review setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Review setContent(String content) {
        this.content = content;
        return this;
    }

    public int getStarQuantity() {
        return starQuantity;
    }

    public Review setStarQuantity(int starQuantity) {
        this.starQuantity = starQuantity;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Review setPost(Post post) {
        this.post = post;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Review setUser(User user) {
        this.user = user;
        return this;
    }
}
