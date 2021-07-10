package com.company.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtility {

    public static List<String> readLinesFromFile() {
        List<String> csvFileLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("/home/krypton/IdeaProjects/cliCrud/src/com/company/database.csv"))){
            while (scanner.hasNext()) {
                csvFileLines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku!");
        }
        return csvFileLines;
    }


    public static void writeLinesToFile(List<String> writeLinesToFile) {
        try (Writer writer = new FileWriter("/home/krypton/IdeaProjects/cliCrud/src/com/company/database.csv")){
            for (String e : writeLinesToFile) {
                writer.write(e + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Problem z dostępem do pliku!");
        }
    }
}
