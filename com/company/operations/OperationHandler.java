package com.company.operations;

import com.company.models.Author;
import com.company.models.Book;
import com.company.utility.CsvUtility;
import com.company.utility.FileUtility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class OperationHandler {
    public static final String PATH_TO_BOOK_DB = "/home/krypton/IdeaProjects/cliCrud/src/com/company/database.csv";
    public static final String PATH_TO_AUTHOR_DB = "/home/krypton/IdeaProjects/cliCrud/src/com/company/authors.csv";
    private List<Book> books;
    private List<Author> authors;
    private List<Operationable> operations = new ArrayList<>();
    private Scanner scanner;

    public OperationHandler(Scanner scanner) {
        authors = getAuthorsFromFile(PATH_TO_AUTHOR_DB);
        books = getBooksFromFile(PATH_TO_BOOK_DB);
        this.scanner = scanner;
    }

    private List<Book> getBooksFromFile(String pathToDb) {
        List<String> csvFileLines = (List<String>)FileUtility.readLinesFromFile(pathToDb);

        return csvFileLines.stream()
                .map(lineToSerialize -> CsvUtility.serialize(lineToSerialize, authors))
                .collect(Collectors.toList());
    }

    private List<Author> getAuthorsFromFile(String pathToDb) {
        List<String> csvFileLines = (List<String>)FileUtility.readLinesFromFile(pathToDb);

        return csvFileLines.stream()
                .map(CsvUtility::serializeAuthors)
                .collect(Collectors.toList());
    }

    public void saveBooksToFile(String pathToDb) {
        List<String> booksToSaveInCsv = books.stream()
                .map(CsvUtility::deserialize)
                .toList();

        FileUtility.writeLinesToFile(booksToSaveInCsv, pathToDb);
    }

    public void saveAuthorsToFile(String pathToDb) {
        List<String> authorsToSaveInCsv = authors.stream()
                .map(CsvUtility::deserializeAuthors)
                .toList();

        FileUtility.writeLinesToFile(authorsToSaveInCsv, pathToDb);
    }
    public Collection<Operationable> getOperations() {
        operations.add(new BookSearcher(scanner, books));
        operations.add(new BookDeleter(scanner, books));
        operations.add(new BookAlterer(scanner, books, authors));
        operations.add(new BookAdder(scanner, books, authors));
        return operations;
    }
}
