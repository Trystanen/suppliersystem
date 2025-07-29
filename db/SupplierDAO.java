package suppliersystem.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import suppliersystem.domain.Supplier;
import suppliersystem.domain.TypePerson;

public class SupplierDAO {

    public void insertSupplier(Supplier supplier) {
        String sqlSupplier = "INSERT INTO supplier (company_name, type_person, document_number) VALUES (?, ?, ?) RETURNING id";
        String sqlPerson = "INSERT INTO person (name, email, supplier_id) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psSupplier = conn.prepareStatement(sqlSupplier)) {
                psSupplier.setString(1, supplier.getCompanyName());
                psSupplier.setString(2, supplier.getTypePerson().name());
                psSupplier.setString(3, supplier.getDocumentNumber());

                ResultSet rs = psSupplier.executeQuery();
                if (rs.next()) {
                    int supplierId = rs.getInt(1);

                    try (PreparedStatement psPerson = conn.prepareStatement(sqlPerson)) {
                        psPerson.setString(1, supplier.getRequester().getName());
                        psPerson.setString(2, supplier.getRequester().getEmail());
                        psPerson.setInt(3, supplierId);
                        psPerson.executeUpdate();
                    }
                }
                conn.commit();
                System.out.println("Supplier created.");
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();

        String sql = "SELECT * FROM supplier";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setCount(rs.getInt("id"));
                supplier.setCompanyName(rs.getString("company_name"));
                supplier.setDocumentNumber(rs.getString("document_number"));
                supplier.setTypePerson(TypePerson.valueOf((rs.getString("type_person"))));
                suppliers.add(supplier);
            }

        } catch (SQLException e) {
            System.out.println("Error when searching for suppliers: " + e.getMessage());
        }

        return suppliers;
    }
}
