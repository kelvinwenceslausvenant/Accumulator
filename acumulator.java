import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acc extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private double total = 0;

    public Acc() {
        setTitle("Accumulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        // Create components
        inputField = new JTextField(10);
        JButton addButton = new JButton("Add");
        resultLabel = new JLabel("Total: 0");

        // Add action listener to the button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double number = Double.parseDouble(inputField.getText());
                    total += number;
                    resultLabel.setText("Total: " + total);
                    inputField.setText(""); // Clear the input field
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Acc.this, "Please enter a valid number.");
                }
            }
        });

        // Create a panel and add components to it
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(new JLabel("Enter a number:"));
        panel.add(inputField);
        panel.add(addButton);

        // Add panel and result label to the frame
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(resultLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Acc().setVisible(true);
            }
        });
    }
}
