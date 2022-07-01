import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginUser{

    public LoginUser(){
    }

    public boolean loginUser(String username,String password) {
        Conn conn   = new Conn();
        PreparedStatement stmt = conn.prepareStatement("SELECT password FROM users WHERE username='"+username+"';");
        try{
            ResultSet rs = stmt.executeQuery();
            rs.next();
            String dbPassword = rs.getString("password");
            if (!Objects.equals(dbPassword, password)) {
                System.out.println("Failed to log in.");
                return false;
            } else {
                System.out.println("Logged in");
                return true;
            }

        } catch (SQLException e) {
           return false;
        }

    }
}
