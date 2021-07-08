package com.company.operations;

import java.util.ArrayList;
import java.util.List;

public class OperationHandler {

    List<Operationable> operationsList = new ArrayList<>();

    public static List<Operationable> getOperations() {
        return operationsList;
    }
}
