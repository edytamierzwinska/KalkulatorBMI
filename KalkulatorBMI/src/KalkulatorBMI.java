/*
Kalkulator BMI jest prostą aplikacją umożliwiającą użytkownikom obliczenie swojego wskaźnika masy ciała na podstawie podanych wartości wzrostu i wagi. 
Aplikacja została napisana w języku Java z wykorzystaniem biblioteki Swing do stworzenia interfejsu użytkownika.
*/

import javax.swing.*;
import java.awt.FlowLayout;

public class KalkulatorBMI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Kalkulator BMI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel labelWzrost = new JLabel("Wzrost w cm:");
        JLabel labelWaga = new JLabel("Waga w kg:");
        JLabel labelWynik = new JLabel("BMI:");

        JTextField fieldWzrost = new JTextField(10);
        JTextField fieldWaga = new JTextField(10);
        JTextField fieldWynik = new JTextField(10);
        fieldWynik.setEditable(false);

        JButton przyciskOblicz = new JButton("Oblicz");
        przyciskOblicz.addActionListener(e -> {
            try {
                double wzrost = Double.parseDouble(fieldWzrost.getText()) / 100;
                double waga = Double.parseDouble(fieldWaga.getText());

                double bmi = waga / (wzrost * wzrost);

                fieldWynik.setText(String.format("%.2f", bmi));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Podane wartości są nieprawidłowe.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(labelWzrost);
        panel.add(fieldWzrost);
        panel.add(labelWaga);
        panel.add(fieldWaga);
        panel.add(przyciskOblicz);
        panel.add(labelWynik);
        panel.add(fieldWynik);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }
}
