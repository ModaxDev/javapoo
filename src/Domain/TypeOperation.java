package Domain;

public class TypeOperation {
    private int id;
    private String nom_ope;

    public TypeOperation(int id, String nom_ope) {
        this.id = id;
        this.nom_ope = nom_ope;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_ope() {
        return nom_ope;
    }

    public void setNom_ope(String nom_ope) {
        this.nom_ope = nom_ope;
    }
}
