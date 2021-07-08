package com.company;

import com.company.operations.OperationHandler;
import com.company.operations.Operationable;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Operationable> operations = OperationHandler.getOperations();
    }
}
