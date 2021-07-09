package com.company.operations;

import com.company.models.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OperationHandler {

    List<Book> books;
    List<Operationable> operations;

    public OperationHandler() {
        getBooksFromFile();
    }

    private List<Book> getBooksFromFile() {
        List<String> csvFileLines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("/home/krypton/IdeaProjects/cliCrud/src/com/company/database.csv"))){
            while (scanner.hasNext()) {
                csvFileLines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku!");
        }
        csvFileLines.stream()
                .map(line -> line.split(","))
                .close();

        for (String line : csvFileLines) {
            try {
                Book book = new Book();
                book.setId(Integer.parseInt(line[0]));
                book.setTitle(line[1]);
                book.setAuthorId(Integer.parseInt(line[2]));
                book.setPublicationDate(Integer.parseInt(line[3]));
            } catch (NumberFormatException e) {
                System.out.println("Oczekiwano liczby!"); //w razie ręcznej podmiany liczby w pliku
                return null;
            }
        }
    }

    public void saveBooksToFile() {
        try (Writer writer = new FileWriter("/home/krypton/IdeaProjects/cliCrud/src/com/company/database.csv")){
            books.stream()
                    .forEach(book -> {
                        try {
                            writer.write(CsvUtility.deserialize(book) + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            writer.flush();
        } catch (IOException e) {
            System.out.println("Problem z dostępem do pliku!");
        }
    }

    public static List<Operationable> getOperations() {
        List<String> linesFromCsv = FileUtility.readLinesFromFile();
        List<Book> booksFromCsv = new ArrayList<>();

        for (String line : linesFromCsv) {
            booksFromCsv.add(CsvUtility.serialize(line));
        }

        List<Operationable> operationsList = new ArrayList<>();
        operationsList.add(new BookSearcher(booksFromCsv));
        operationsList.add(new BookDeleter(booksFromCsv));
        operationsList.add(new BookAlterer(booksFromCsv));
        operationsList.add(new BookAdder(booksFromCsv));
        return operationsList;
    }
}
