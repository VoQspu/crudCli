package com.company.utility;

import com.company.exceptions.SpecialCaseException;
import com.company.models.Book;

public class CsvUtility {
    private static final String SEPARATOR = ",";

    public static Book serialize(String lineToSerialize) {
        Book book = new Book();
        String[] splitString = lineToSerialize.split(SEPARATOR);

        try {
            book.setId(Integer.parseInt(splitString[0]));
            book.setTitle(splitString[1]);
            book.setAuthorId(Integer.parseInt(splitString[2]));
            book.setPublicationDate(Integer.parseInt(splitString[3]));
        } catch (NumberFormatException e) {
            throw new SpecialCaseException("W miejscu liczby znajduje się w pliku csv coś innego, program zakończy się!"); //w razie ręcznej podmiany liczby w pliku
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SpecialCaseException("Elementu o tym indeksie nie ma w tablicy");
        }

        return book;
    }

    public static String deserialize(Book book) {
        StringBuilder builder = new StringBuilder();
        builder.append(book.getId())
                .append(SEPARATOR)
                .append(book.getTitle())
                .append(SEPARATOR)
                .append(book.getAuthorId())
                .append(SEPARATOR)
                .append(book.getPublicationDate());
        return builder.toString();
    }
}
