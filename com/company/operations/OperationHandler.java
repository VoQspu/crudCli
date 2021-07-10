package com.company.operations;

import com.company.exceptions.CsvIntegrityFailedException;
import com.company.models.Book;
import com.company.utility.CsvUtility;
import com.company.utility.FileUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class OperationHandler {
    private List<Book> books;
    private List<Operationable> operations = new ArrayList<>();
    private Scanner scanner;

    public OperationHandler(Scanner scanner) {
        books = getBooksFromFile();
        this.scanner = scanner;
    }

    private List<Book> getBooksFromFile(){
        List<String> csvFileLines = FileUtility.readLinesFromFile();

        return csvFileLines.stream()
                .map(CsvUtility::serialize)
                .collect(Collectors.toList());
    }

    public void saveBooksToFile() {
        List<String> booksToSaveInCsv = books.stream()
                .map(CsvUtility::deserialize)
                .toList();

        FileUtility.writeLinesToFile(booksToSaveInCsv);
    }

    public List<Operationable> getOperations() {
        operations.add(new BookSearcher(scanner, books));
        operations.add(new BookDeleter(scanner, books));
        operations.add(new BookAlterer(scanner, books));
        operations.add(new BookAdder(scanner, books));
        return operations;
    }
}
