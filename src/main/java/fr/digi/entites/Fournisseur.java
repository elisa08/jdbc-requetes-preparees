package fr.digi.entites;

public class Fournisseur {

    private String nom;

    public Fournisseur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toString(){
        return this.nom;
    }

}
