package com.company.operations;

import com.company.models.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperationHandler {
    List<Book> books;
    Scanner scanner;

    {
        try {
            scanner = new Scanner(new File("/home/krypton/IdeaProjects/cliCrud/src/com/company/database.csv"));
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                books.add(scanner.nextLine().)
            }
        } catch (FileNotFoundException e) {
            System.out.println("Podany plik nie istnieje!");
        }
    }

    List<Operationable> operationsList = new ArrayList<>();

    public static List<Operationable> getOperations() {
        return operationsList;
    }
}
