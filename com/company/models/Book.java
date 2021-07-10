package com.company.models;

public class Book {
    int id;
    String title;
    int authorId;
    int publicationDate;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public String toString() {
        return getId() + "," + getTitle() + "," + getAuthorId() + getPublicationDate();
    }
}
