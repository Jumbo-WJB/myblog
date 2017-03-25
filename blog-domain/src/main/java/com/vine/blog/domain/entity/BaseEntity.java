package com.vine.blog.domain.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Date;

/**
 * Base class to derive entity classes from.
 */
@MappedSuperclass
public abstract class BaseEntity {

    public interface Summary {}
    public interface Protected extends Summary {}
    public interface Private extends Protected {}

    @Id
    @JsonView(Summary.class)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "created_at")
    @JsonView(Summary.class)
    private Date createdAt;

    @Version
    @Column(name = "updated_at")
    @JsonView(Summary.class)
    private Date updatedAt;

    /**
     * Returns the identifier of the entity.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        this.createdAt = now;
        this.updatedAt = now;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }

        BaseEntity that = (BaseEntity) obj;

        return this.id.equals(that.getId());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
