import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;

public class PasswortKnackerGUI extends JFrame {
    static String password = "";
    static String crackedPassword = "";

    private final JTextField passwordField;
    private final JButton crackButton;
    private final JLabel resultLabel;

    public PasswortKnackerGUI() {
        setTitle("Passwort Knacker");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        getContentPane().setBackground(new Color(0x141414));
        setLocationRelativeTo(null);

        passwordField = new JPasswordField();
        crackButton = new JButton("Knacken");
        resultLabel = new JLabel();

        passwordField.setHorizontalAlignment(JPasswordField.CENTER);
        passwordField.setForeground(new Color(0xffffff));
        passwordField.setFont(new Font("Netflix Sans", Font.PLAIN, 35));
        passwordField.setBorder(null);
        passwordField.setOpaque(false);

        crackButton.setOpaque(false);
        crackButton.setContentAreaFilled(false);
        crackButton.setBorderPainted(true);
        crackButton.setBorder(BorderFactory.createLineBorder(new Color(0xffffff)));
        crackButton.setForeground(new Color(0xffffff));
        crackButton.setFocusPainted(false);
        crackButton.setFont(new Font("Netflix Sans", Font.PLAIN, 35));

        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setVerticalAlignment(JLabel.CENTER);
        resultLabel.setForeground(new Color(0xffffff));
        resultLabel.setBorder(null);
        resultLabel.setFont(new Font("Netflix Sans", Font.PLAIN, 35));

        crackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crackButton.setEnabled(false);
                UIManager.put("Button.disabledText", new ColorUIResource(new Color(0xff0000)));
                crackButton.setBorder(BorderFactory.createLineBorder(new Color(0xff0000)));
                password = passwordField.getText();
                algorithmus();
                resultLabel.setText(crackedPassword);
            }
        });

        add(passwordField);
        add(crackButton);
        add(resultLabel);

        setVisible(true);
    }

    public static void algorithmus() {
        for (int i = 0; i < password.length(); i++) {
            for (char c = 33; c <= 126; c++) {
                System.out.println(c);
                if (c == password.charAt(i)) {
                    crackedPassword += c;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new PasswortKnackerGUI();
    }
}
