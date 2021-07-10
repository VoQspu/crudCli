package com.company.operations;

import com.company.models.Book;
import com.company.utility.CsvUtility;
import com.company.utility.FileUtility;

import java.util.ArrayList;
import java.util.List;


public class OperationHandler {

    List<Book> books;
    List<Operationable> operations;

    public OperationHandler() {
        getBooksFromFile();
    }

    private List<Book> getBooksFromFile() {
        List<String> csvFileLines = FileUtility.readLinesFromFile();
        List<Book> booksFromCsv = new ArrayList<>();

        csvFileLines.stream()
                .map(line -> booksFromCsv.add(CsvUtility.serialize(line)))
                .close();

        return booksFromCsv;
    }

    public void saveBooksToFile() {
        List<String> booksPreparedToSave = new ArrayList<>();

        books.stream()
                .map(book -> booksPreparedToSave.add(CsvUtility.deserialize(book)))
                .close();

        FileUtility.writeLinesToFile(booksPreparedToSave);
    }

    public List<Operationable> getOperations() {
        operations.add(new BookSearcher(books));
        operations.add(new BookDeleter(books));
        operations.add(new BookAlterer(books));
        operations.add(new BookAdder(books));
        return operations;
    }
}
