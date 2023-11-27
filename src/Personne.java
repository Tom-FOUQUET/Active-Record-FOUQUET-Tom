
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
        this.idPersonne=-1;
    }

    public static ArrayList<Personne> findAll() throws Exception {
        Connection co = DBConnection.getConexion();
        String query = "Select nom,prenom from Personne";
        PreparedStatement prepared = co.prepareStatement(query);
        prepared.executeQuery();
        ResultSet Res = prepared.getResultSet();
        Personne p=null;
        ArrayList<Personne> list = new ArrayList<Personne>(0);
        while (Res.next())
        {
            p= new Personne (Res.getString(1),Res.getString(2));
            list.add(p);
        }
        return list;
    }

    public static Personne findById(int i) throws Exception {
        Connection co = DBConnection.getConexion();
        String query = "Select nom,prenom from Personne where id = ?";
        PreparedStatement prepared = co.prepareStatement(query);
        prepared.setInt(1,i);
        prepared.executeQuery();
        ResultSet Res = prepared.getResultSet();
        Personne p=null;
        while (Res.next())
        {
             p= new Personne (Res.getString(1),Res.getString(2));
             p.setIdPersonne(i);
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
        String deleteString = "DROP TABLE Personne";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(deleteString);
        System.out.println("2) supresion table Personne\n");
    }

    public static ArrayList<Personne> findByName(String fincher) throws Exception{
        Connection co = DBConnection.getConexion();
        String query = "Select * from Personne where nom = ?";
        PreparedStatement prepared = co.prepareStatement(query);
        prepared.setString(1,fincher);
        prepared.executeQuery();
        ResultSet Res = prepared.getResultSet();
        Personne p=null;
        ArrayList<Personne> list = new ArrayList<Personne>(0);
        while (Res.next())
        {
            p= new Personne (Res.getString(2),Res.getString(3));
            p.setIdPersonne(Res.getInt(1));
            list.add(p);
        }
        return list;
    }

    public void save() throws Exception
    {
        if (idPersonne==-1)
        {
        String SQLPrep = "INSERT INTO Personne (nom, prenom) VALUES (?,?)";
        PreparedStatement prep = DBConnection.getConexion().prepareStatement(SQLPrep);
        prep.setString(1 ,this.nom);
        prep.setString(2,this.prenom);
        prep.executeUpdate();
        }
        Personne.findByName(this.nom);
    }

    public void delete() throws Exception
    {
        Connection connect =DBConnection.getConexion();
        String deleteString = "DELETE from PERSONNE where id = ?";
        PreparedStatement stmt = connect.prepareStatement(deleteString);
        stmt.setInt(1,this.idPersonne);
        stmt.executeUpdate();
        idPersonne=-1;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public void setNom(String s) {
        this.nom=s;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return idPersonne;
    }

    @Override
    public String toString() {
        String res = "nom :"+this.nom + " prenom :"+this.prenom+" id ="+this.idPersonne;
        return res;
    }
}
