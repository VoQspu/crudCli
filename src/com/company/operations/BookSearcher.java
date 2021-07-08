package com.company.operations;

import com.company.models.Book;

import java.util.List;
import java.util.Scanner;

public class BookSearcher implements Operationable {
    List<Book> books;

    public BookSearcher(List<Book> books) {
        this.books = books;
    }

    @Override
    public String getDescription() {
        return "1. Wyszukaj książkę";
    }

    @Override
    public void performAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id książki: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            for (Book b : books) {
                if (b.getId() == choice) {
                    System.out.println(CsvUtility.deserialize(b));
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        }
    }
}
