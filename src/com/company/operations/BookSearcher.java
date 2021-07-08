package com.company.operations;

import com.company.models.Book;

import java.util.List;
import java.util.Scanner;

public class BookSearcher implements Operationable {

    List<Book> database;
    int searchedId;

    public BookSearcher(List<Book> database) {
        this.database = database;
    }

    @Override
    public String getDescription() {
        return "1. Wyszukaj książkę\n";
    }

    @Override
    public void performAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id książki: ");
        try {
            searchedId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Nie podano cyfry!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nie ma opcji o takim numerze!");
        }

        for (Book element : database) {
            if (element.getId() == searchedId ) {
                System.out.println(element);
            }
        }
    }
}
