package com.company;

import com.company.operations.OperationHandler;
import com.company.operations.Operationable;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperationHandler operationHandler = new OperationHandler(scanner);
        List<Operationable> operations = operationHandler.getOperations();

        while (true) {
            System.out.println("Aby zakończyć program wybierz 0");
            for (Operationable operation : operations) {
                System.out.println(operation.getDescription());
            }
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    break;
                }
                operations.get(choice-1).performAction();
            } catch (NumberFormatException e) {
                System.out.println("Nie podano cyfry!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nie ma wyboru o takim numerze!");
            }
        }
        operationHandler.saveBooksToFile();
    }
}
