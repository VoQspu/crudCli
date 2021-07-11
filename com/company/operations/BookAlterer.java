package com.company.operations;

import com.company.exceptions.AuthorNotFoundException;
import com.company.exceptions.BookNotFoundException;
import com.company.models.Author;
import com.company.models.Book;
import com.company.utility.SearchUtility;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BookAlterer implements Operationable {
    private List<Book> books;
    private List<Author> authors;
    private Scanner scanner;

    public BookAlterer(Scanner scanner, List<Book> books, List<Author> authors) {
        this.books = books;
        this.scanner = scanner;
        this.authors = authors;
    }

    @Override
    public String getDescription() {
        return "3. Zmień książkę";
    }

    @Override
    public void performAction() {
        System.out.println("Podaj id książki, którą chcesz zmienić: ");
        try {
            System.out.println(books);
            int choice = Integer.parseInt(scanner.nextLine());
            Optional<Book> optionalBook = SearchUtility.findBook(books, choice);
            System.out.println(optionalBook.map(this::editBook)
                    .orElseThrow(BookNotFoundException::new));
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        } catch (BookNotFoundException e) {
            System.out.println(e);
        }
    }

    private String editBook(Book book) throws NumberFormatException {
        System.out.println(book);
        System.out.println("""
                Co chcesz zmienić?
                1. tytuł
                2. autora przypisanego do książki
                3. rok publikacji
                """);
        int alterChoice = Integer.parseInt(scanner.nextLine());

        try {
            switch (alterChoice) {
                case 1 -> changeTitle(scanner, book);
                case 2 -> changeAuthor(scanner, book);
                case 3 -> changePublicationDate(scanner, book);
                default -> System.out.println("Nieprawidłowa opcja!");
            }
        } catch (AuthorNotFoundException e) {
            System.out.println(e);
        }
        return "Książka została poprawnie zedytowana";
    }

    private void changeTitle(Scanner scanner, Book book) {
        System.out.println("Podaj nowy tytuł:");
        book.setTitle(scanner.nextLine());
    }

    private void changeAuthor(Scanner scanner, Book book) throws AuthorNotFoundException {
        System.out.println(authors);
        System.out.println("Podaj id autora, który ma zostac przypisany do książki");

        Author author = SearchUtility.findAuthor(authors, Integer.parseInt(scanner.nextLine()))
                .orElseThrow(AuthorNotFoundException::new);
        book.setAuthor(author);
    }

    private void changePublicationDate(Scanner scanner, Book book) {
        System.out.println("Podaj nowy rok publikacji:");
        int newPublicationDate = Integer.parseInt(scanner.nextLine());
        book.setPublicationDate(newPublicationDate);
    }
}
