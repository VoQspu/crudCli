package com.company.operations;

import com.company.exceptions.AuthorNotFoundException;
import com.company.models.Author;
import com.company.models.Book;
import com.company.utility.SearchUtility;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class BookAdder implements Operationable {
    private List<Book> books;
    private List<Author> authors;
    private Scanner scanner;

    public BookAdder(Scanner scanner, Collection<Book> books, Collection<Author> authors) {
        this.books = (List<Book>)books;
        this.scanner = scanner;
        this.authors = (List<Author>)authors;
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

        try {
            for (Author author : authors) {
                System.out.println(SearchUtility.findElementById(authors, author.getId()).get());
            }
            System.out.println("""
                    Czy chcesz przypisać istniejącego autora, czy dodać nowego?
                    1. Dodaj nowego
                    2. Przypisz istniejącego
                    """);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> newAuthor = addNewAuthor();
                case 2 -> {
                    System.out.println("Podaj id istniejącego autora");
                    newAuthor = SearchUtility.findElementById(authors, Integer.parseInt(scanner.nextLine()))
                            .orElseThrow(AuthorNotFoundException::new);
                }
                default -> System.out.println("Nie ma takiej opcji!");
            }

            System.out.println("Podaj tytuł:");
            newBook.setTitle(scanner.nextLine());
            System.out.println("Podaj rok publikacji:");
            newBook.setPublicationDate(Integer.parseInt(scanner.nextLine()));

            newBook.setAuthor(newAuthor);
            books.add(newBook);
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        } catch (AuthorNotFoundException e) {
            System.out.println(e);
            return;
        }
    }
    private Author addNewAuthor() {
        Author author = new Author();
        author.setId(authors.size() + 1);

        System.out.println("Podaj imię autora:");
        author.setFirstName(scanner.nextLine());
        System.out.println("Podaj naziwsko autora:");
        author.setLastName((scanner.nextLine()));

        authors.add(author);
        return author;
    }
}
