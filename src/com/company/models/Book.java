package com.company.models;

public class Book {
    int id;
    String title;
    int authorId;
    int publicationDate;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(int authorId) {
        this.authorId = authorId;
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

    public int getAuthorId() {
        return authorId;
    }

    public int getPublicationDate() {
        return publicationDate;
    }
}
