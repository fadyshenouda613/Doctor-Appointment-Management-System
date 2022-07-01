import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterUser {
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final String userName;

    public RegisterUser(String firstName, String lastName, String password, String email, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.userName = username;
    }

    public boolean registerUser() {
        Conn con = new Conn();
        String query = "'" + this.firstName + "','" + this.lastName + "','" + this.email + "','" + this.password + "','"+this.userName+"'";
        PreparedStatement stmt;
        stmt = con.prepareStatement("insert into users(firstname,lastname, email, password,username) VALUES (" + query + ")");
        if(!checkUserValidation()){


        try {
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        return false;
    }
    private boolean checkUserValidation(){
        Conn con = new Conn();
        PreparedStatement stmt = con.prepareStatement("SELECT username FROM users WHERE username='"+this.userName+"';");
        try{
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
}
