package com.company.utility;

import com.company.exceptions.AuthorNotFoundException;
import com.company.exceptions.SpecialCaseException;
import com.company.models.Author;
import com.company.models.Book;

import java.util.Collection;
import java.util.List;

public class CsvUtility {
    private static final String SEPARATOR = ",";

    public static Book serialize(String lineToSerialize, Collection<Author> authors) {
        Book book = new Book();
        String[] splitString = lineToSerialize.split(SEPARATOR);

        try {
            book.setId(Integer.parseInt(splitString[0]));
            book.setTitle(splitString[1]);
            book.setPublicationDate(Integer.parseInt(splitString[3]));
            Author author = SearchUtility.findElementById(authors, Integer.parseInt(splitString[2]))
                    .orElseThrow(AuthorNotFoundException::new);
            book.setAuthor(author);
        } catch (NumberFormatException e) {
            throw new SpecialCaseException("W miejscu liczby znajduje się w pliku csv coś innego, program zakończy się!"); //w razie ręcznej podmiany liczby w pliku
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SpecialCaseException("Elementu o tym indeksie nie ma w tablicy");
        } catch (AuthorNotFoundException e) {
            throw new SpecialCaseException("Książka posiada przypisane id autora, który nie istnieje w bazie!");
        }
        return book;
    }

    public static Author serializeAuthors(String lineToSerialize) {
        Author author = new Author();
        String[] splitString = lineToSerialize.split(SEPARATOR);

        try {
            author.setId(Integer.parseInt(splitString[0]));
            author.setFirstName(splitString[1]);
            author.setLastName(splitString[2]);
        } catch (NumberFormatException e) {
            throw new SpecialCaseException("W miejscu liczby znajduje się w pliku csv coś innego, program zakończy się!"); //w razie ręcznej podmiany liczby w pliku
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SpecialCaseException("Elementu o tym indeksie nie ma w tablicy");
        }
        return author;
    }

    public static String deserialize(Book book) {
        StringBuilder builder = new StringBuilder();
        builder.append(book.getId())
                .append(SEPARATOR)
                .append(book.getTitle())
                .append(SEPARATOR)
                .append(book.getAuthor().getId())
                .append(SEPARATOR)
                .append(book.getPublicationDate());
        return builder.toString();
    }

    public static String deserializeAuthors(Author author) {
        StringBuilder builder = new StringBuilder();
        builder.append(author.getId())
                .append(SEPARATOR)
                .append(author.getFirstName())
                .append(SEPARATOR)
                .append(author.getLastName());
        return builder.toString();
    }
}
