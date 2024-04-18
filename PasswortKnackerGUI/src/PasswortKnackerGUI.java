import javax.swing.*;

public class PasswortKnackerGUI {

    static String password = "";
    static String crackedPassword = "";

    public static void main(String[] args) {
        // Create and show the GUI
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("Passwort Knacker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add components
        JLabel label = new JLabel("Gib dein Passwort ein (KEIN LEERZEICHEN):");
        JTextField textField = new JPasswordField(20);
        JButton button = new JButton("Okay");
        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);

        button.addActionListener(_ -> {
            password = textField.getText();
            algorithmus();
            textArea.setText("Passwort geknackt: " + crackedPassword);
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(textArea);

        // Set up the frame
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void algorithmus() {
        for (int i = 0; i < password.length(); i++) {
            for (char c = 33; c <= 126; c++) {
                if (c == password.charAt(i)) {
                    crackedPassword += c;
                    break;
                }
            }
        }
    }
}
