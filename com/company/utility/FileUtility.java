package com.company.utility;

import com.company.exceptions.SpecialCaseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class FileUtility {

    public static Collection<String> readLinesFromFile(String pathToCsv) {
        Collection<String> csvFileLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(pathToCsv))){
            while (scanner.hasNext()) {
                csvFileLines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new SpecialCaseException("Nie ma takiego pliku csv!");
        }
        return csvFileLines;
    }


    public static void writeLinesToFile(Collection<String> writeLinesToFile, String pathToCsv) {
        try (Writer writer = new FileWriter(pathToCsv)){
            for (String e : writeLinesToFile) {
                writer.write(e + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Problem z dostępem do pliku, zapis nie nastąpił!");
        }
    }
}
