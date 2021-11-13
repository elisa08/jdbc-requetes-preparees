import fr.digi.dao.ArticleDao;
import fr.digi.entites.Articles;
import fr.digi.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ArticleDaoJdbc implements ArticleDao {

    ResourceBundle props= ResourceBundle.getBundle("db");
    String url= props.getString("jdbc.url");
    String user= props.getString("jdbc.user");
    String pass= props.getString("jdbc.password");

    @Override
    public List<Articles> extraire() {

        try(Connection connection= DriverManager.getConnection(url,user,pass)) {

            List<Articles> articles= new ArrayList<>();
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM article INNER JOIN fournisseur ON article.id_fou=fournisseur.id");

            while (resultSet.next()){
                Articles article= new Articles(null,null,0.0,null);
                String designation= resultSet.getString("DESIGNATION");
                String ref= resultSet.getString("REF");
                Double prix= resultSet.getDouble("PRIX");
                String nom= resultSet.getString("NOM");
                Fournisseur fournisseur= new Fournisseur(nom);

               article.setRef(ref);
               article.setDesignation(designation);
               article.setPrix(prix);
               article.setFournisseur(fournisseur);

               articles.add(article);

            }
            return articles;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Articles articles) {

        try(Connection connection= DriverManager.getConnection(url,user,pass)) {



            Fournisseur fournisseur= articles.getFournisseur();
            String nom= fournisseur.getNom();
            int idFou= 0;



            PreparedStatement preparedStatement1= connection.prepareStatement("SELECT id FROM fournisseur WHERE nom=?");
            preparedStatement1.setString(1,nom);
            ResultSet resultSet= preparedStatement1.executeQuery();

            while (resultSet.next()){

                idFou= resultSet.getInt("ID");
                System.out.println(idFou);

            }

            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO article (ref,designation,prix,id_fou) VALUES (?,?,?,?)");
            String nomA= articles.getDesignation();
            String ref= articles.getRef();
            Double prix= articles.getPrix();
            preparedStatement.setString(1, ref);
            preparedStatement.setString(2,nomA);
            preparedStatement.setDouble(3,prix);
            preparedStatement.setInt(4,idFou);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {

            e.getMessage();
        }

    }

    @Override
    public void update(Articles articles) {

        try(Connection connection= DriverManager.getConnection(url,user,pass)) {

            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM article WHERE designation LIKE ?");

            preparedStatement.setString(1,"peinture mate%");

            ResultSet resultSet= preparedStatement.executeQuery();

            String nom= null;
            Double prix= 0.0;
            while (resultSet.next()){

               nom= resultSet.getString("DESIGNATION");
               prix= resultSet.getDouble("prix");
               System.out.println(nom + prix);

               PreparedStatement preparedStatement1= connection.prepareStatement("UPDATE article SET prix=? WHERE designation=?");
               preparedStatement1.setDouble(1,prix-(prix*0.25));
               preparedStatement1.setString(2,nom);
               preparedStatement1.executeUpdate();

            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public boolean delete() {

        try(Connection connection= DriverManager.getConnection(url,user,pass)) {

            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM article WHERE designation LIKE ?");
            preparedStatement.setString(1,"peinture%");
            ResultSet resultSet= preparedStatement.executeQuery();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public void caculMoyennePrix() {

        try(Connection connection= DriverManager.getConnection(url,user,pass)) {

            Statement statement= connection.createStatement();
            ResultSet result= statement.executeQuery("SELECT AVG(prix) as moyenne FROM article");
            while (result.next()){

                Double moyenne= result.getDouble(1);
                System.out.println(moyenne);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
