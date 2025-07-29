package suppliersystem.service;

import suppliersystem.domain.Person;
import suppliersystem.domain.Supplier;
import suppliersystem.domain.TypePerson;
import suppliersystem.util.InputReader;

import java.util.ArrayList;
import java.util.Scanner;

public class SupplierService {
    private static ArrayList<Supplier> suppliers = new ArrayList<>();

    public static String readCompanyName(Scanner input){
        String companyName = InputReader.readNonEmptyString(input, "Company Name");
        return companyName;
    }

    public static String readDocumentNumber(Scanner input){
        String documentNumber = InputReader.readNonEmptyString(input, "Document Number");
        return documentNumber;
    }

    public static TypePerson readTypePerson (Scanner input) {
        TypePerson typePerson = null;
        while (typePerson == null) {
            try {
                String typePersonInput = InputReader.readNonEmptyString(input, "Legal Nature");
                typePerson = TypePerson.valueOf(typePersonInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid type. Insert again (PF or PJ)");
            }
        }
        return typePerson;
    }

    public static Person readRequester (Scanner input){
        String requesterName = InputReader.readNonEmptyString(input, "Name");
        String requesterEmail = InputReader.readNonEmptyString(input, "Email");
        Person requester = new Person(requesterName, requesterEmail);
        return requester;
    }

    public static void createSupplier(Scanner input){
        Supplier sup = new Supplier(readCompanyName(input), readTypePerson(input), readDocumentNumber(input), readRequester(input));
        suppliers.add(sup);
        System.out.println("Supplier created.");
    }

    public static void listSuppliers(){
        System.out.println("List of Suppliers");
        if (suppliers.isEmpty()){
            System.out.println("No supplier registered.");
        } else {
            for (Supplier supplier : suppliers){
                supplier.printSupplier();
            }
        }
    }

    public static void removeSupplierById(Scanner input){
        Supplier supplierRemove = null;

        System.out.println("Insert your ID: ");
        int idRemove = input.nextInt();
        input.nextLine();

        if (suppliers.isEmpty()){
            System.out.println("No supplier registered.");
        } else {
            for (Supplier supplier : suppliers){
                if (supplier.getId() == idRemove){
                    supplierRemove = supplier;
                    break;
                }
            }
        }

        if (supplierRemove != null){
            suppliers.remove(supplierRemove);
            System.out.println("Supplier of ID "+ idRemove +" successfully removed.");
        } else {
            System.out.println("Supplier with ID "+ idRemove +" not found.");
        }
    }

    public static void editSupplierById(Scanner input){
        Supplier supplierEdit = null;

        System.out.println("Enter the ID you want to edit.");
        int idEdit = input.nextInt();
        input.nextLine();

        if (suppliers.isEmpty()){
            System.out.println("Supplier not found.");
        } else {
            for (Supplier supplier : suppliers) {
                if (supplier.getId() == idEdit){
                    supplierEdit = supplier;
                    break;
                }
            }
        }

        if (supplierEdit != null){
            System.out.println("Editing supplier: ID "+ supplierEdit.getId());
            System.out.println("Leave blank to keep the current value.");

            System.out.println("Company Name: ");
            String newCompanyName = input.nextLine();
            if (!newCompanyName.trim().isEmpty()) {
                supplierEdit.setCompanyName(newCompanyName);
            }

            System.out.println("Legal Nature: ");
            String newTypePersonInput = input.nextLine();
            if (!newTypePersonInput.trim().isEmpty()){
                try {
                    TypePerson newTypePerson = TypePerson.valueOf(newTypePersonInput.toUpperCase());
                    supplierEdit.setTypePerson(newTypePerson);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid type. Legal nature not updated.");
                }
            }

            System.out.println("Fiscal Document Number: ");
            String newNumDocFiscal = input.nextLine();
            if (!newNumDocFiscal.trim().isEmpty()) {
                supplierEdit.setDocumentNumber(newNumDocFiscal);
            }

            System.out.println("Requester: ");
            String newRequesterName = input.nextLine();
            if (!newRequesterName.trim().isEmpty()) {
                supplierEdit.getRequester().setName(newRequesterName);
            }

            System.out.println("Requester Email: ");
            String newRequesterEmail = input.nextLine();
            if (!newRequesterEmail.trim().isEmpty()) {
                supplierEdit.getRequester().setEmail(newRequesterEmail);
            }
            System.out.println("Supplier updated!");
        } else {
            System.out.println("Supplier with ID " + idEdit + " not found.");
        }
    }
}
