package com.company.operations;

import com.company.models.Book;

import java.util.List;
import java.util.Scanner;

public class BookAdder implements Operationable {
    private List<Book> books;
    private Scanner scanner;

    public BookAdder(Scanner scanner, List<Book> books) {
        this.books = books;
        this.scanner = scanner;
    }

    @Override
    public String getDescription() {
        return "4. Dodaj książkę";
    }

    @Override
    public void performAction() {
        Book newBook = new Book();

        newBook.setId(books.size() + 1); //nowe id większe o 1, id zaczyna się od 1 w csv

        try {
            System.out.println("Podaj tytuł:");
            newBook.setTitle(scanner.nextLine());
            System.out.println("Podaj id autora:");
            newBook.setAuthorId(Integer.parseInt(scanner.nextLine()));
            System.out.println("Podaj rok publikacji:");
            newBook.setPublicationDate(Integer.parseInt(scanner.nextLine()));
            books.add(newBook);
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        }
    }
}
