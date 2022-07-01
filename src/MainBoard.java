import javax.swing.*;
import java.awt.*;

public class MainBoard extends JFrame {
    private JPanel mainPanel;
    public MainBoard(){
        super("Login");
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1500, 1000));
        this.setLocationRelativeTo(null);

    }
}
