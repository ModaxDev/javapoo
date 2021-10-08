package Domain;

public class CompteCourant extends Compte{

    private double decouvert;
    private String secu;

    public String getSecu() {
        return secu;
    }

    public void setSecu(String secu) {
        this.secu = secu;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public String toString() {
        return "CompteCourant{" +
                "decouvert=" + decouvert +
                "solde=" + getSolde() +
                '}';
    }
}
