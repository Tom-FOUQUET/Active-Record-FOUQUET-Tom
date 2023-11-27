import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

public class TestDBConnection {

        String dbname1;
        String dbname2;

        Connection connection;
        @BeforeEach
        void setUp() throws SQLException {
        dbname1 = "testpersonne";
        dbname2 = "unebase";
        DBConnection.setNomDB(dbname1);
        try {
            connection = DBConnection.getConexion();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        }

    @Test
    public void testsetNomDBOK(){
        try{
            setUp();
            assertEquals(dbname1,DBConnection.getDbName());
            DBConnection.setNomDB(dbname2);
            assertEquals(dbname2,DBConnection.getDbName());

        }
        catch (Exception e )
        {

        }

    }

    @Test
    public void testNomDBEgale()
    {
    try{
            setUp();
            assertEquals(dbname1,DBConnection.getDbName());
            DBConnection.setNomDB(dbname1);
            assertEquals(dbname1,DBConnection.getDbName());

        }
        catch (Exception e )
        {

        }
    }


    @Test
    public void testunobjetinstancier()
    {
        try
        {
        setUp();
        assertEquals("Les deux objet doivent être égaux",DBConnection.getConexion(),DBConnection.getConexion());
        }
        catch (Exception e )
        {
            System.out.println(e.getMessage());
        }

    }


}
