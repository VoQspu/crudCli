package com.company.operations;

import com.company.models.Book;
import com.company.utility.CsvUtility;
import com.company.utility.FileUtility;

import java.util.ArrayList;
import java.util.List;


public class OperationHandler {

    List<Book> books;
    List<Operationable> operations = new ArrayList<>();

    public OperationHandler() {
        books = getBooksFromFile();
    }

    private List<Book> getBooksFromFile() {
        List<String> csvFileLines = FileUtility.readLinesFromFile();

        return csvFileLines.stream()
                .map(line -> CsvUtility.serialize(line))
                .toList();
    }

    public void saveBooksToFile() {
        FileUtility.writeLinesToFile(books.stream()
        .map(book -> CsvUtility.deserialize(book))
        .toList());
    }

    public List<Operationable> getOperations() {
        operations.add(new BookSearcher(books));
        operations.add(new BookDeleter(books));
        operations.add(new BookAlterer(books));
        operations.add(new BookAdder(books));
        return operations;
    }
}
