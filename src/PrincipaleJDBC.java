

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PrincipaleJDBC {

    // IL FAUT PENSER A AJOUTER MYSQLCONNECTOR AU CLASSPATH

    public static void main(String[] args) throws SQLException {
        Connection connect = DBConnection.getConexion();

        // creation de la table Personne
        {
            String createString = "CREATE TABLE Personne ( " + "ID INTEGER  AUTO_INCREMENT, "
                    + "NOM varchar(40) NOT NULL, " + "PRENOM varchar(40) NOT NULL, " + "PRIMARY KEY (ID))";
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(createString);
            System.out.println("1) creation table Personne\n");
        }

        // ajout de personne avec requete preparee
        {
            String SQLPrep = "INSERT INTO Personne (nom, prenom) VALUES (?,?);";
            PreparedStatement prep;
        }
    }
}