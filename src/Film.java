import java.sql.Connection;
import java.sql.Statement;

public class Film {


    public static void createTable() throws Exception{
        Connection connect =DBConnection.getConexion();
        String createString = "CREATE TABLE `Film` (`id` int(11) NOT NULL,`titre` varchar(40) NOT NULL,`id_rea` int(11) DEFAULT) ENGINE=InnoDB DEFAULT CHARSET=latin1)";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(createString);
        System.out.println("1) creation table Personne\n");}

    public static void deleteTable() throws Exception {
        Connection connect =DBConnection.getConexion();
        String deleteString = "DROP TABLE Film)";
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(deleteString);
    }
}
