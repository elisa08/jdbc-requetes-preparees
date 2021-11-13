package fr.digi.dao;

import fr.digi.entites.Fournisseur;

import java.util.List;

public interface FournisseurDao {


    List<Fournisseur> extraire(String nom);
    void insert(Fournisseur fournisseur);
    void update(String ancienNom, String nouveauNom);
    boolean delete(Fournisseur fournisseur);
}
