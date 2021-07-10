package com.company.operations;

import com.company.models.Book;
import com.company.utility.SearchUtility;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BookAlterer implements Operationable {
    private List<Book> books;
    private Scanner scanner;

    public BookAlterer(Scanner scanner, List<Book> books) {
        this.books = books;
        this.scanner = scanner;
    }

    @Override
    public String getDescription() {
        return "3. Zmień książkę";
    }

    @Override
    public void performAction() {
        System.out.println("Podaj id książki, którą chcesz zmienić: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            Optional<Book> optionalBook = SearchUtility.findBook(books, choice);
            if (optionalBook.isEmpty()) {
                System.out.println("Nie znaleziono książki!");
                return;
            }
            Book foundBook = optionalBook.get();
            System.out.println(foundBook);
            System.out.println("""
                    Co chcesz zmienić?
                    1. tytuł
                    2. autor id
                    3. rok publikacji
                    """);
            int alterChoice = Integer.parseInt(scanner.nextLine());


            switch (alterChoice) {
                case 1 -> changeTitle(scanner, foundBook);
                case 2 -> changeAuthorId(scanner, foundBook);
                case 3 -> changePublicationDate(scanner, foundBook);
                default -> System.out.println("Nieprawidłowa opcja!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        }
    }

    private void changeTitle(Scanner scanner, Book book) {
        System.out.println("Podaj nowy tytuł:");
        book.setTitle(scanner.nextLine());
    }

    private void changeAuthorId(Scanner scanner, Book book) {
        System.out.println("Podaj nowe id autora:");
        int newAuthorId = Integer.parseInt(scanner.nextLine());
        book.setAuthorId(newAuthorId);
    }

    private void changePublicationDate(Scanner scanner, Book book) {
        System.out.println("Podaj nowy rok publikacji:");
        int newPublicationDate = Integer.parseInt(scanner.nextLine());
        book.setPublicationDate(newPublicationDate);
    }
}
