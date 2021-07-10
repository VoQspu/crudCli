package com.company.operations;

import com.company.models.Book;
import com.company.utility.CsvUtility;

import java.util.List;
import java.util.Scanner;

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
        Book foundBook = new Book();

        System.out.println("Podaj id książki, którą chcesz zmienić: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            for (Book b : books) {
                if (b.getId() == choice) {
                    foundBook = b;
                    break; //książka znaleziona, przewij pętlę
                }
            }
            if (foundBook != null) {
                System.out.println(CsvUtility.deserialize(foundBook));
                System.out.println("Co chcesz zmienić?\n" +
                        "1. id\n" +
                        "2. tytuł\n" +
                        "3. autor id\n" +
                        "4. rok publikacji\n");
                int alterChoice = Integer.parseInt(scanner.nextLine());


                switch (alterChoice) {
                    case 1:
                        changeId(scanner, foundBook);
                        break;
                    case 2:
                        changeTitle(scanner, foundBook);
                        break;
                    case 3:
                        changeAuthorId(scanner, foundBook);
                        break;
                    case 4:
                        changePublicationDate(scanner, foundBook);
                        break;
                    default:
                        System.out.println("Nieprawidłowa opcja!");
                        break;
                }
            } else {
                System.out.println("Nie znaleziono książki!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        }
    }

    private void changeId(Scanner scanner, Book book) {
        System.out.println("Podaj nowe id:");
        int newId = Integer.parseInt(scanner.nextLine());
        book.setId(newId);
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