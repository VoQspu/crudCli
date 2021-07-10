package com.company.operations;

import com.company.models.Book;
import com.company.utility.CsvUtility;
import com.company.utility.SearchUtility;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BookSearcher implements Operationable {
    List<Book> books;
    Scanner scanner;

    public BookSearcher(Scanner scanner, List<Book> books) {
        this.books = books;
        this.scanner = scanner;
    }

    @Override
    public String getDescription() {
        return "1. Wyszukaj książkę";
    }

    @Override
    public void performAction() {
        System.out.println("Podaj id książki: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            Optional<Book> foundBook = SearchUtility.findBook(books, choice);
            if (foundBook.isPresent()) {
                System.out.println(foundBook.get());
            } else {
                System.out.println("Nie ma książki o takim id!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        }
    }
}
