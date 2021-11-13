import fr.digi.entites.Articles;
import fr.digi.entites.Fournisseur;

import java.util.List;

public class TestArticles {

    public static void main(String[] args){


        Fournisseur fournisseur= new Fournisseur("la maison de la peinture");

        Articles article= new Articles("ART55095","Peinture bleue mate 1L",15.55,fournisseur);

        ArticleDaoJdbc adj= new ArticleDaoJdbc();

        //adj.insert(article);

        //adj.update(article);

        adj.caculMoyennePrix();

        List<Articles> articles= adj.extraire();

        for (Articles a:articles){

            System.out.println(a);

        }

        adj.delete();

        Fournisseur fournisseur1= new Fournisseur("la maison de la peinture");

        FournisseurDaoJdbc fdj= new FournisseurDaoJdbc();

        fdj.delete(fournisseur1);
    }






}
