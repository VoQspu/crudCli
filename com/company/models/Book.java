package com.company.models;

public class Book extends AbstractCsvEntity {
    private String title;
    private Author author;
    private int publicationDate;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public String toString() {
        return getId() + "," + getTitle() + "," + getAuthor() + "," + getPublicationDate();
    }
}
