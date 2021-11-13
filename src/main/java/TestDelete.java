import fr.digi.dao.ArticleDao;
import fr.digi.dao.FournisseurDao;
import fr.digi.entites.Articles;
import fr.digi.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestDelete {

    public static void main(String[] args){

        Fournisseur fournisseur= new Fournisseur("Delormes");
        FournisseurDaoJdbc fdj= new FournisseurDaoJdbc();

        fdj.delete(fournisseur);


    }


}
