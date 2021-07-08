package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudController {

    Scanner sc;

    {
        try {
            sc = new Scanner(new File("/home/krypton/IdeaProjects/cliCrud/src/com/company/database.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void add() throws Exception {
        List<String> database = readDatabase();
        database.add("book_id" + "," + "title" + "," + "author_id" + "," + "publication_date");
        sc.useDelimiter(",");

    }

    void delete() {

    }

    void search() {

    }

    void alter() {

    }

    void printAll() throws Exception {
        System.out.println(readDatabase());
    }

    List<String> readDatabase() throws Exception{
        List<String> database = new ArrayList<>();
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            database.add(sc.next());
        }
        sc.close();
        return database;
    }
}
