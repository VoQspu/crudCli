package com.company.operations;

import com.company.models.Author;
import com.company.models.Book;

import java.util.List;
import java.util.Scanner;

public class BookAdder implements Operationable {
    private List<Book> books;
    private List<Author> authors;
    private Scanner scanner;

    public BookAdder(Scanner scanner, List<Book> books, List<Author> authors) {
        this.books = books;
        this.scanner = scanner;
        this.authors = authors;
    }

    @Override
    public String getDescription() {
        return "4. Dodaj książkę";
    }

    @Override
    public void performAction() {
        Book newBook = new Book();
        Author newAuthor = new Author();

        newBook.setId(books.size() + 1); //nowe id większe o 1, id zaczyna się od 1 w csv
        newAuthor.setId(authors.size() + 1);

        try {
            System.out.println("Podaj tytuł:");
            newBook.setTitle(scanner.nextLine());
            System.out.println("Podaj imię autora:");
            newAuthor.setFirstName(scanner.nextLine());
            System.out.println("Podaj naziwsko autora:");
            newAuthor.setLastName((scanner.nextLine()));
            System.out.println("Podaj rok publikacji:");
            newBook.setPublicationDate(Integer.parseInt(scanner.nextLine()));

            newBook.setAuthor(newAuthor);
            books.add(newBook);
            authors.add(newAuthor);
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        }
    }
}
