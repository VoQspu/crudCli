package com.company.operations;

import com.company.exceptions.BookNotFoundException;
import com.company.models.Book;
import com.company.utility.SearchUtility;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BookDeleter implements Operationable{
    private List<Book> books;
    private Scanner scanner;

    public BookDeleter(Scanner scanner, List<Book> books) {
        this.books = books;
        this.scanner = scanner;
    }

    @Override
    public String getDescription() {
        return "2. Usuń książkę";
    }

    @Override
    public void performAction() {
        System.out.println("Podaj id książki, którą chcesz usunąć: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            Optional<Book> bookToDelete = SearchUtility.findElementById(books, choice);
            bookToDelete.map(book -> books.remove(book))
                    .orElseThrow(BookNotFoundException::new);
            System.out.println("Pomyślnie usunięto książkę");
        } catch (NumberFormatException e) {
            System.out.println("Oczekiwano liczby!");
        } catch (BookNotFoundException e) {
            System.out.println(e);
        }
    }
}
