package suppliersystem.db;

import suppliersystem.domain.Supplier;
import suppliersystem.service.SupplierService;

import java.util.List;
import java.util.Scanner;

public class SupplierRepository {
    public static void createSupplierDB(Scanner input){
        Supplier sup = new Supplier(SupplierService.readCompanyName(input), SupplierService.readTypePerson(input), SupplierService.readDocumentNumber(input), SupplierService.readRequester(input));
        new suppliersystem.db.SupplierDAO().insertSupplier(sup);
    }

    public static void getAllSuppliersDB(){
        List<Supplier> suppliers = SupplierDAO.getAllSuppliers();
        if (suppliers.isEmpty()) {
            System.out.println("Supplier not found.");
        } else {
            for (Supplier s : suppliers) {
                System.out.println(s);
            }
        }
    }
}
