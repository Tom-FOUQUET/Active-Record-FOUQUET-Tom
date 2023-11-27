import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

private static Connection connect;
private static String dbName = "testpersonne";
    private  DBConnection() throws SQLException {


            connect =DriverManager.getConnection("jdbc:mysql://localhost/"+dbName, "root", "");


    }

    public static synchronized Connection getConexion()
    {
        if (connect==null)
            try {
                new DBConnection();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        return connect;
    }

    public static synchronized void setNomDB(String nomDB)
    {if (nomDB!=null && nomDB!=dbName){
     dbName=nomDB;
     connect =null;
    }

    }
}
