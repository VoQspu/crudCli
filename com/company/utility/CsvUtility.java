package com.company.utility;

import com.company.models.Book;

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
            System.out.println("Oczekiwano liczby!"); //w razie ręcznej podmiany liczby w pliku
            return null;
        }

        return book;
    }

    public static String deserialize(Book book) {
        StringBuilder builder = new StringBuilder();
        builder.append(book.getId()).append(",")
                .append(book.getTitle()).append(",")
                .append(book.getAuthorId()).append(",")
                .append(book.getPublicationDate());
        return builder.toString();
    }
}
