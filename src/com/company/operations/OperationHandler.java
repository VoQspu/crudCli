package com.company.operations;

import java.util.ArrayList;
import java.util.List;


public class OperationHandler {

    public static List<Operationable> getOperations() {
        //getbooks()
        List<Operationable> operationsList = new ArrayList<>();
        operationsList.add(new BookSearcher());
        operationsList.add(new BookDeleter());
        operationsList.add(new BookAlterer());
        operationsList.add(new BookAdder());
//        FileUtility.readLinesFromFile();
        return operationsList;
    }
}
