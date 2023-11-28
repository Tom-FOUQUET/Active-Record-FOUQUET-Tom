package activeRecord;

import activeRecord.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PrincipaleJDBC {

    // IL FAUT PENSER A AJOUTER MYSQLCONNECTOR AU CLASSPATH

    public static void main(String[] args) throws SQLException {
        Connection connect = DBConnection.getConexion();

        // creation de la table activeRecord.Personne
        {
            String createString = "CREATE TABLE activeRecord.Personne ( " + "ID INTEGER  AUTO_INCREMENT, "
                    + "NOM varchar(40) NOT NULL, " + "PRENOM varchar(40) NOT NULL, " + "PRIMARY KEY (ID))";
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(createString);
            System.out.println("1) creation table activeRecord.Personne\n");
        }

        // ajout de personne avec requete preparee
        {
            String SQLPrep = "INSERT INTO activeRecord.Personne (nom, prenom) VALUES (?,?);";
            PreparedStatement prep;
        }
    }
}