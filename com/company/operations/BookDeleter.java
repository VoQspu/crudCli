package com.company.operations;

import com.company.models.Book;

import java.util.List;
import java.util.Scanner;

public class BookDeleter implements Operationable{
    List<Book> books;

    public BookDeleter(List<Book> books) {
        this.books = books;
    }

    @Override
    public String getDescription() {
        return "2. Usuń książkę";
    }

    @Override
    public void performAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id książki, którą chcesz usunąć: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            books.stream()
                    .filter(book -> book.getId() == choice)
                    .findFirst()
                    .ifPresent(book -> books.remove(book));
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        }
    }
}
