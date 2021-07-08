package com.company;

import java.util.Scanner;

public class CrudView {
    Scanner scanner = new Scanner(System.in);
    CrudController controller = new CrudController();

    int listOptions() {
        System.out.println("\nMożliwe opcje: \n" +
                "0. Wyjdź \n" +
                "1. Wyświetl wszystko \n" +
                "2. Dodaj \n" +
                "3. Usuń \n" +
                "4. Zmień \n" +
                "5. Wyszukaj \n" +
                "Którą operację wykonać?: ");

        return Integer.parseInt(scanner.nextLine());
    }

    void start() throws Exception {
        switch (listOptions()) {
            case 0:
                System.exit(0);
                break;
            case 1:
                controller.printAll();
                break;
            case 2:
                controller.add();
                break;
            case 3:
                controller.delete();
                break;
            case 4:
                controller.alter();
                break;
            case 5:
                controller.search();
                break;
            default:
                System.out.println("\nNieprawidłowa opcja, spróbuj ponownie.\n");
                break;
        }
    }

}
