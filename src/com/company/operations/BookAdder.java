package com.company.operations;

public class BookAdder implements Operationable{
    @Override
    public String getDescription() {
        return "4. Dodaj książkę";
    }

    @Override
    public void performAction() {
        System.out.println("Dodaję książkę");
    }
}
