package com.kraljevic.luka.examples.bucketlistapp.bucketlist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class BucketListItem {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String title;

    private String description;

    private Date targetDate;

    private boolean isDone;

    protected BucketListItem() {

    }

    public BucketListItem(Long id, String username, String title, String description, Date targetDate, boolean isDone) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BucketListItem that = (BucketListItem) o;
        return isDone == that.isDone && Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(targetDate, that.targetDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, title, description, targetDate, isDone);
    }
}
