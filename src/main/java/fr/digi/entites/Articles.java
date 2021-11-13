package fr.digi.entites;

public class Articles {

    private String ref;
    private String designation;
    private Double prix;
    private Fournisseur fournisseur;


    public Articles(String ref, String designation, Double prix, Fournisseur fournisseur) {
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String toString(){
        return ref+" "+designation + " " + prix + " " + fournisseur;
    }
}
