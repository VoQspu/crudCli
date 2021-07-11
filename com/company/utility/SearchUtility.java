package com.company.utility;

import com.company.models.Author;
import com.company.models.Book;

import java.util.List;
import java.util.Optional;

public class SearchUtility {
    public static Optional<Book> findBook(List<Book> books, int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    public static Optional<Author> findAuthor(List<Author> authors, int id) {
        return authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst();
    }
}
