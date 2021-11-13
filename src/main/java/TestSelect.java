import fr.digi.entites.Fournisseur;

import java.util.List;

public class TestSelect {

    public static void main(String[] args){


        FournisseurDaoJdbc fdj= new FournisseurDaoJdbc();

        List<Fournisseur> fournisseurs= fdj.extraire("Dupont");

        for(Fournisseur f : fournisseurs){

            System.out.println(f);

        }
    }


}
