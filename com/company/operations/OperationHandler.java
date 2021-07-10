package com.company.operations;

import com.company.models.Book;
import com.company.utility.CsvUtility;
import com.company.utility.FileUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class OperationHandler {

    List<Book> books;
    List<Operationable> operations = new ArrayList<>();

    public OperationHandler() {
        books = getBooksFromFile();
    }

    private List<Book> getBooksFromFile() {
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
        operations.add(new BookSearcher(books));
        operations.add(new BookDeleter(books));
        operations.add(new BookAlterer(books));
        operations.add(new BookAdder(books));
        return operations;
    }
}
