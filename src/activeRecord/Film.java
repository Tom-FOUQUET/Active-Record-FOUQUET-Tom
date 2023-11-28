package activeRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Film {

int idFilm ;
String titre;
int id_real;

public Film(String t, Personne p) throws Exception
{
    titre=t;
    id_real=p.getId();
    idFilm = -1;
}
    public static void createTable() throws Exception{
        Connection connect = DBConnection.getConexion();
        String createString = "CREATE TABLE Film (id INTEGER  AUTO_INCREMENT NOT NULL,titre varchar(40) NOT NULL,id_real int(11),PRIMARY KEY (ID))";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(createString);
        System.out.println("1) creation table Film\n");}

    public static void deleteTable() throws Exception {
        Connection connect =DBConnection.getConexion();
        String deleteString = "DROP TABLE Film";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(deleteString);
        System.out.println("2) supresion table Film\n");
    }


    public static Film findById(int i) throws Exception {
        Connection co = DBConnection.getConexion();
        String query = "Select titre,id_real from FILM where id = ?";
        PreparedStatement prepared = co.prepareStatement(query);
        prepared.setInt(1,i);
        prepared.executeQuery();
        ResultSet Res = prepared.getResultSet();
        Film p=null;
        while (Res.next())
        {
            p= new Film (Res.getString(1), Personne.findById(Res.getInt(2)));
            p.setIdFilm(i);
        }
        return p;
        }


    public void save() throws Exception
    {
        if (idFilm==-1)
        {
            String SQLPrep = "INSERT INTO Film (titre, id_real) VALUES (?,?)";
            PreparedStatement prep = DBConnection.getConexion().prepareStatement(SQLPrep);
            prep.setString(1 ,this.titre);
            prep.setInt(2,this.id_real);
            prep.executeUpdate();
        }
        Personne.findByName(this.titre);
    }

    public void delete() throws Exception
    {
        Connection connect =DBConnection.getConexion();
        String deleteString = "DELETE from Film where id = ?";
        PreparedStatement stmt = connect.prepareStatement(deleteString);
        stmt.setInt(1,this.idFilm);
        stmt.executeUpdate();
        idFilm=-1;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getId() {
        return idFilm;
    }

    public String getTitre() {
        return titre;
    }

    public Personne getRealisateur() throws Exception
    {
        return Personne.findById(id_real);
    }

    public String toString()  {
        String res = "titre :"+this.titre +" idFilm ="+this.idFilm + "\n";
        return res;
    }
}
