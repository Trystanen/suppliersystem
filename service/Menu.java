package suppliersystem.service;

import suppliersystem.db.SupplierRepository;
import suppliersystem.domain.Supplier;
import java.util.Scanner;

public class Menu {

    public static void showMainMenu(){
        System.out.println("----MENU----");
        System.out.println("1 - Test Mode");
        System.out.println("2 - Database Mode");
        System.out.println("0 - CLOSE");
    }

    public static void showDbMenu(){
        System.out.println("----MENU----");
        System.out.println("1 - Create supplier");
        System.out.println("2 - List suppliers");
        System.out.println("0 - Back");
    }

    public static void showTestMenu(){
        System.out.println("----MENU----");
        System.out.println("1 - Create supplier");
        System.out.println("2 - List suppliers");
        System.out.println("3 - Edit test vendor by ID");
        System.out.println("4 - Remove test vendor by ID");
        System.out.println("0 - Back");
    }

    public static void mainMenu(Scanner input){
        String option = "-1";
        do {
            showMainMenu();
            option = input.nextLine();
            switch (option){
                case "1":
                    testMenu(input);
                    break;
                case "2":
                    dbMenu(input);
                    break;
                case "0":
                    System.out.println("Closing...");
                    break;
                default:
                    System.out.println("Invalid value.");
                    break;
            }
        } while (!option.equals("0"));
    }

    public static void testMenu(Scanner input){
        String option = "-1";
        do {
            showTestMenu();
            option = input.nextLine();
            switch (option){
                case "1":
                    SupplierService.createSupplier(input);
                    break;
                case "2":
                    SupplierService.listSuppliers();
                    break;
                case "3":
                    SupplierService.editSupplierById(input);
                    break;
                case "4":
                    SupplierService.removeSupplierById(input);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid value.");
                    break;
            }
        } while (!option.equals("0"));
    }

    public static void dbMenu(Scanner input){
        String option = "-1";
        do {
            showDbMenu();
            option = input.nextLine();
            switch (option){
                case "1":
                    SupplierRepository.createSupplierDB(input);
                    break;
                case "2":
                    SupplierRepository.getAllSuppliersDB();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid value.");
                    break;
            }
        } while (!option.equals("0"));
    }
}