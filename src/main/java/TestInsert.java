import fr.digi.entites.Fournisseur;

public class TestInsert {

    public static void main(String[] args){

        Fournisseur fournisseur= new Fournisseur("Durand");
        FournisseurDaoJdbc fdj= new FournisseurDaoJdbc();

        fdj.insert(fournisseur);


    }
}
