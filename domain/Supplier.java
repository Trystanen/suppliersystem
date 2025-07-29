package suppliersystem.domain;

public class Supplier{
    private final int id;
    private static int count = 0;
    private String companyName;
    private TypePerson typePerson;
    private String documentNumber;
    private Person requester;

    public Supplier(){
        this.id = ++count;
    }

    public Supplier(String companyName, TypePerson typePerson, String documentNumber, Person requester) {
        this.id = ++count;
        this.companyName = companyName;
        this.typePerson = typePerson;
        this.documentNumber = documentNumber;
        this.requester = requester;
    }

    public void printSupplier(){
        System.out.print("ID: "+this.id+" / ");
        System.out.print("Company Name: "+this.companyName+" / ");
        System.out.print("Legal Nature: "+this.typePerson.name+" / ");
        System.out.print("Document number: "+this.documentNumber+" / ");
        System.out.print("Requester: "+this.requester.getName()+" / ");
        System.out.print("Requester Email: "+this.requester.getEmail()+" / ");
    }

    @Override
    public String toString() {
        return
                "ID:" + id +
                ", Company Name = " + companyName +
                ", Document Number = " + documentNumber +
                ", Legal Nature = " + typePerson;
    }

    public int getId() {
        return id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setTypePerson(TypePerson typePerson) {
        this.typePerson = typePerson;
    }
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Person getRequester() {
        return requester;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Supplier.count = count;
    }

    public String getCompanyName() {
        return companyName;
    }

    public TypePerson getTypePerson() {
        return typePerson;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setRequester(Person requester) {
        this.requester = requester;
    }
}