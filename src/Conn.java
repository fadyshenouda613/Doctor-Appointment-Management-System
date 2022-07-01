import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conn{
    private Connection con;
    private PreparedStatement stmt;
    public Conn(){
        try {
            String databaseURL = "jdbc:postgresql://localhost:5432/PharmaDoc";
            con = DriverManager.getConnection(databaseURL, "postgres", "12345");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement prepareStatement(String s) {
        try{
            stmt = con.prepareStatement(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }
}
