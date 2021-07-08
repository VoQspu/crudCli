package com.company.operations;

import com.company.models.Book;

import java.util.List;

public class CsvUtility {

    public static Book serialize(String lineToSerialize) {
        Book book = new Book();
        String[] splitString = lineToSerialize.split(",");

        try {
            book.setId(Integer.parseInt(splitString[0]));
            book.setTitle(splitString[1]);
            book.setAuthorId(Integer.parseInt(splitString[2]));
            book.setPublicationDate(Integer.parseInt(splitString[3]));
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
            System.exit(0);
        }

        return book;
    }

    public static String deserialize(Book book) {
        StringBuilder builder = new StringBuilder();
        builder.append(book.getId() + ",")
                .append(book.getTitle() + ",")
                .append(book.getAuthorId() + ",")
                .append(book.getPublicationDate());
        return builder.toString();
    }
}
