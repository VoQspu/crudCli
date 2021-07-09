package com.company.operations;

import com.company.models.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookAdder implements Operationable {
    List<Book> books;

    public BookAdder(List<Book> books) {
        this.books = books;
    }

    @Override
    public String getDescription() {
        return "4. Dodaj książkę";
    }

    @Override
    public void performAction() {
        Scanner scanner = new Scanner(System.in);
        List<String> addedBooks = new ArrayList<>();
        Book newBook = new Book();

        newBook.setId(books.size()); //nowe id większe o 1

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

        for (Book b : books) {
            addedBooks.add(CsvUtility.deserialize(b));
        }
        FileUtility.writeLinesToFile(addedBooks);
    }
}
