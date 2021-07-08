package com.company.operations;

import com.company.models.Book;

import java.util.ArrayList;
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
        List<String> deletedBooks = new ArrayList<>();
        System.out.println("Podaj id książki, którą chcesz usunąć: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            for (Book b : books) {
                if (b.getId() == choice) {
                    books.remove(b);
                }
            }
            for (Book b : books) {
                deletedBooks.add(CsvUtility.deserialize(b));
            }
            FileUtility.writeLinesToFile(deletedBooks);
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        }
    }
}
