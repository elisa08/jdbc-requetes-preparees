import fr.digi.dao.FournisseurDao;
import fr.digi.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements FournisseurDao{


        ResourceBundle props= ResourceBundle.getBundle("db");
        String url= props.getString("jdbc.url");
        String user= props.getString("jdbc.user");
        String pass= props.getString("jdbc.password");


        @Override
        public List<Fournisseur> extraire(String nom) {

            try(Connection connect= DriverManager.getConnection(url, user, pass)) {
                List<Fournisseur> fournisseurs= new ArrayList<>();

                PreparedStatement statement= connect.prepareStatement("SELECT * FROM fournisseur WHERE nom=?");
                statement.setString(1,nom);
                ResultSet resultat= statement.executeQuery();

                while(resultat.next()){

                    String name= resultat.getString("NOM");
                    Fournisseur fournisseur= new Fournisseur(name);
                    fournisseurs.add(fournisseur);

                }
                return fournisseurs;

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            return null;
        }



        @Override
        public void insert(Fournisseur fournisseur) {

            try(Connection connection= DriverManager.getConnection(url,user,pass)) {

                PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO fournisseur (nom) VALUES (?)");
                String nom= fournisseur.getNom();
                preparedStatement.setString(1,nom);
                preparedStatement.executeUpdate();



            } catch (SQLException e) {

                e.getMessage();
            }

        }

        @Override
        public void update(String ancienNom, String nouveauNom) {

            try(Connection connection= DriverManager.getConnection(url,user,pass)) {

                PreparedStatement preparedStatement= connection.prepareStatement("UPDATE fournisseur SET nom='"+nouveauNom+"' WHERE nom=?");
                preparedStatement.setString(1,ancienNom);
                preparedStatement.executeUpdate();



            } catch (SQLException e) {

                e.getMessage();
            }
        }

        @Override
        public boolean delete(Fournisseur fournisseur) {

            try(Connection connection= DriverManager.getConnection(url,user,pass)) {

                PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM fournisseur WHERE nom=?");
                preparedStatement.setString(1,fournisseur.getNom());
                preparedStatement.executeUpdate();



            } catch (SQLException e) {

                e.getMessage();
            }
            return false;
        }
    }

