import com.mysql.cj.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Personne {
    String nom;
    String prenom;
    int idPersonne;

    public Personne(String nom,String prenom)
    {
        this.prenom=prenom;
        this.nom=nom;
    }

    public static ArrayList<Personne> findAll() {
    }

    public static Personne findById(int i) throws Exception {
        Connection co = DBConnection.getConexion();
        String query = "Select nom,prenom from Personne where id = ?";
        PreparedStatement prepared = co.prepareStatement(query);
        prepared.executeQuery();
        ResultSet Res = prepared.getResultSet();
        Personne p=null;
        while (Res.next())
        {
             p= new Personne (Res.getString(1),Res.getString(2));
        }
        return p;
    }

    public static void createTable() throws Exception{
        Connection connect =DBConnection.getConexion();
        String createString = "CREATE TABLE Personne ( " + "ID INTEGER  AUTO_INCREMENT, "
                + "NOM varchar(40) NOT NULL, " + "PRENOM varchar(40) NOT NULL, " + "PRIMARY KEY (ID))";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(createString);
        System.out.println("1) creation table Personne\n");}

    public static void deleteTable() throws Exception {
        Connection connect =DBConnection.getConexion();
        String deleteString = "DROP TABLE Personne)";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(deleteString);
    }

    public void save()
    {
        String SQLPrep = "INSERT INTO Personne (nom, prenom) VALUES (?,?);";
        PreparedStatement prep;

    }


}
