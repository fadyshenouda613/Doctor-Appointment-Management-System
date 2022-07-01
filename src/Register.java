import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class Register extends JFrame {
    private JPanel mainPanel;
    private JLabel logoLabel;
    private JLabel registerLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JLabel usernameLabel;
    private JLabel firstNameLabel;
    private JLabel lastName;
    private JLabel passwordLabel;
    private JTextField phoneField;
    private JLabel confirmLabel;
    private JTextField firstNameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmField;
    private JButton registerButton;
    private JButton cancelButton;
    private JTextField lastNameField;
    private JTextField userNameTextField;

    public Register() {
        super("Register");
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("monitoring.png");
        Image image = ImageIcon.getImage();
        Image newImg = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon = new ImageIcon(newImg);
        logoLabel.setIcon(ImageIcon);
        cancelButton.addActionListener(e -> backToLogin());
        registerButton.addActionListener(e -> registerUser());


    }

    private void backToLogin() {
        dispose();
        new Login();
    }

    private void registerUser() {
        if (this.firstNameField.getText().isEmpty() || this.emailField.getText().isEmpty() || String.valueOf(this.passwordField.getPassword()).isEmpty() || String.valueOf(this.confirmField.getPassword()).isEmpty() || this.userNameTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel, "One or more fields have not been inserted.");
            return;

        }

        if (this.firstNameField.getText().matches(".*[0-9].*") || this.lastNameField.getText().matches(".*[0-9].*")) {
            JOptionPane.showMessageDialog(mainPanel, "The name you entered is invalid.");
            return;
        }
        if (!isValid(this.emailField.getText())) {
            JOptionPane.showMessageDialog(mainPanel, "The email you entered is invalid.");
            return;
        }
        if (userNameTextField.getText().strip().length() < 6){
            JOptionPane.showMessageDialog(mainPanel,"You must use at least 6 alphabets/numbers as username.","usernameError",JOptionPane.ERROR_MESSAGE);
            return;
        }



            if (String.valueOf(this.passwordField.getPassword()).equals(String.valueOf(this.confirmField.getPassword()))) {
                if (this.passwordField.getPassword().length >= 9) {
                    String firstName = this.firstNameField.getText().strip();
                    String lastName = this.lastNameField.getText().strip();
                    String email = this.emailField.getText().strip();
                    String password = String.valueOf(this.passwordField.getPassword()).strip();
                    String username = this.userNameTextField.getText().strip();
                    RegisterUser user = new RegisterUser(firstName, lastName, password, email,username);

                    if(user.registerUser()) {
                        JOptionPane.showMessageDialog(mainPanel, "Account has been created.");
                        this.dispose();
                        new Login();
                    }
                    else{
                        JOptionPane.showMessageDialog(mainPanel,"The username you entered is an already registered account. Please re-enter another Username.");
                    }
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "The password you entered is too short.");
                }

            } else {
                JOptionPane.showMessageDialog(mainPanel, "Password does not match.");
        }

    }

    private static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static void main(String[] args) {
        new Register();
    }

}
