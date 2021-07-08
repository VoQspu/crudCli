package com.company.operations;

public class BookDeleter implements Operationable{
    @Override
    public String getDescription() {
        return "2. Usuń książkę";
    }

    @Override
    public void performAction() {
        System.out.println("Usuwam książkę");
    }
}
