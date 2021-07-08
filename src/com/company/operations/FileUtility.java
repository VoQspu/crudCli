package com.company.operations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtility {

    public static List<String> readLinesFromFile() {
        List<String> csvFileLines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("/home/krypton/IdeaProjects/cliCrud/src/com/company/database.csv"));
            while (scanner.hasNext()) {
                csvFileLines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku!");
        }
        System.out.println(csvFileLines);
        return csvFileLines;
    }


    public static void writeLineToFile(List<String> toWrite) {
        try {
            Writer writer = new FileWriter("/home/krypton/IdeaProjects/cliCrud/src/com/company/database.csv");
            writer.write(toWrite.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Problem z dostępem do pliku!");
        }
    }
}
