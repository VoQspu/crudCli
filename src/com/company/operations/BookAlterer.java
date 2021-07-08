package com.company.operations;

public class BookAlterer implements Operationable{
    @Override
    public String getDescription() {
        return "3. Zmień książkę";
    }

    @Override
    public void performAction() {
        System.out.println("Zmieniam książkę");
    }
}
