package Domain;

import java.util.Date;

public class Operation {

    private int id;
    private Date dateOpe;
    private Double montant;
    private CompteCourant compteCourant;
    private CompteEpargne compteEpargne;
    private TypeOperation typeOperation;

    public CompteCourant getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(CompteCourant compteCourant) {
        this.compteCourant = compteCourant;
    }

    public CompteEpargne getCompteEpargne() {
        return compteEpargne;
    }

    public void setCompteEpargne(CompteEpargne compteEpargne) {
        this.compteEpargne = compteEpargne;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOpe() {
        return dateOpe;
    }

    public void setDateOpe(Date dateOpe) {
        this.dateOpe = dateOpe;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", dateOpe=" + dateOpe +
                ", montant=" + montant +
                ", typeOperation=" + getTypeOperation().getNom_ope() +
                '}';
    }
}
