package suppliersystem.domain;

public enum TypePerson {
    PJ (0, "Pessoa Juridica", "PJ"),
    PF(1, "Pessoa Fisica", "PF");

    int value;
    String name;
    String shortName;

    TypePerson(int value, String name, String shortName) {
        this.value = value;
        this.name = name;
        this.shortName = shortName;
    }
}
