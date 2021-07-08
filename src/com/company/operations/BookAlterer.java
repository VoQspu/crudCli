package com.company.operations;

import com.company.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class BookAlterer implements Operationable {
    List<Book> books;

    public BookAlterer(List<Book> books) {
        this.books = books;
    }

    @Override
    public String getDescription() {
        return "3. Zmień książkę";
    }

    @Override
    public void performAction() {
        Scanner scanner = new Scanner(System.in);
        List<String> alteredBooks = new ArrayList<>();
        System.out.println("Podaj id książki, którą chcesz zmienić: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            for (Book b : books) {
                if (b.getId() == choice) {
                    System.out.println(CsvUtility.deserialize(b));
                    System.out.println("Co chcesz zmienić?\n" +
                            "1. id\n" +
                            "2. tytuł\n" +
                            "3. autor id\n" +
                            "4. rok publikacji\n");
                    int alterChoice = Integer.parseInt(scanner.nextLine()), tmp;


                    switch (alterChoice) {
                        case 1:
                            System.out.println("Podaj nowe id:");
                            tmp = Integer.parseInt(scanner.nextLine());
                            b.setId(tmp);
                            break;
                        case 2:
                            System.out.println("Podaj nowy tytuł:");
                            b.setTitle(scanner.nextLine());
                            break;
                        case 3:
                            System.out.println("Podaj nowe id autora:");
                            tmp = Integer.parseInt(scanner.nextLine());
                            b.setAuthorId(tmp);
                            break;
                        case 4:
                            System.out.println("Podaj nowy rok publikacji:");
                            tmp = Integer.parseInt(scanner.nextLine());
                            b.setPublicationDate(tmp);
                            break;
                        default:
                            System.out.println("Nieprawidłowa opcja!");
                            break;
                    }
                }
            }
            for (Book b : books) {
                alteredBooks.add(CsvUtility.deserialize(b));
            }
            FileUtility.writeLinesToFile(alteredBooks);
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        }
    }
}
