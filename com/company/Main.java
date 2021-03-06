package com.company;

import com.company.exceptions.SpecialCaseException;
import com.company.operations.OperationHandler;
import com.company.operations.Operationable;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperationHandler operationHandler;
        try {
            operationHandler = new OperationHandler(scanner);
            List<Operationable> operations = (List<Operationable>)operationHandler.getOperations();

            while (true) {
                System.out.println("Aby zakończyć program wybierz 0");
                for (Operationable operation : operations) {
                    System.out.println(operation.getDescription());
                }
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    break;
                }
                operations.get(choice - 1).performAction();
            }
            operationHandler.saveBooksToFile(OperationHandler.PATH_TO_BOOK_DB);
            operationHandler.saveAuthorsToFile(OperationHandler.PATH_TO_AUTHOR_DB);
        } catch (NumberFormatException e) {
            System.out.println("Nie podano cyfry!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nie ma wyboru o takim numerze!");
        } catch (SpecialCaseException e) {
            System.out.println(e);
        }
    }
}
