package Domain;

import java.util.Date;

public class CompteEpargne extends Compte {

    private Date date_fin;
    private String secu;

    public String getSecu() {
        return secu;
    }

    public void setSecu(String secu) {
        this.secu = secu;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "date_fin=" + date_fin +
                "solde=" + getSolde() +
                '}';
    }
}
