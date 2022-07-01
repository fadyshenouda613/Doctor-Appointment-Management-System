import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JPanel mainPanel;
    private JTextField userNameTextField;
    private JPasswordField passwordPasswordField;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel loginPanel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel loginLabel;



    public Login(){
        super("Login");
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.registerButton.addActionListener(e->userRegister());
        this.loginButton.addActionListener(e -> loginUser());
        ImageIcon ImageIcon = new ImageIcon("enter.png");
        Image image = ImageIcon.getImage();
        Image newImg = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon = new ImageIcon(newImg);
        loginLabel.setIcon(ImageIcon);
        loginLabel.setIconTextGap(30);
    }

    private void loginUser() {
        LoginUser login = new LoginUser();
        boolean success =login.loginUser(this.userNameTextField.getText().strip(), String.valueOf(this.passwordPasswordField.getPassword()));
        if(success){
            JOptionPane.showMessageDialog(null,"You have been successfully logged on.","Success",JOptionPane.PLAIN_MESSAGE);
            this.dispose();
            new MainBoard();
        }
        else{
            JOptionPane.showMessageDialog(null,"The username/password you entered is invalid. Please try again.","Success",JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void userRegister() {
        this.dispose();
        new Register();
    }


    public static void main(String[] args) {
        new Login();
    }
}
