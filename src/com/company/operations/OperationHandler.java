package com.company.operations;

import com.company.models.Book;

import java.util.ArrayList;
import java.util.List;


public class OperationHandler {

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
