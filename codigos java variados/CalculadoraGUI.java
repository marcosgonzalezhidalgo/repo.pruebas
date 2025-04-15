import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiqueta y campos de entrada para los números
        JLabel label1 = new JLabel("Número 1:");
        label1.setBounds(50, 30, 100, 30);
        frame.add(label1);

        JTextField numero1Field = new JTextField();
        numero1Field.setBounds(150, 30, 100, 30);
        frame.add(numero1Field);

        JLabel label2 = new JLabel("Número 2:");
        label2.setBounds(50, 70, 100, 30);
        frame.add(label2);

        JTextField numero2Field = new JTextField();
        numero2Field.setBounds(150, 70, 100, 30);
        frame.add(numero2Field);

        // Botones para las operaciones
        JButton sumarBtn = new JButton("Sumar");
        sumarBtn.setBounds(50, 120, 100, 30);
        frame.add(sumarBtn);

        JButton restarBtn = new JButton("Restar");
        restarBtn.setBounds(150, 120, 100, 30);
        frame.add(restarBtn);

        JButton multiplicarBtn = new JButton("Multiplicar");
        multiplicarBtn.setBounds(50, 170, 100, 30);
        frame.add(multiplicarBtn);

        JButton dividirBtn = new JButton("Dividir");
        dividirBtn.setBounds(150, 170, 100, 30);
        frame.add(dividirBtn);

        // Etiqueta para mostrar el resultado
        JLabel resultadoLabel = new JLabel("Resultado:");
        resultadoLabel.setBounds(50, 220, 300, 30);
        frame.add(resultadoLabel);

        // Acciones para los botones
        sumarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(numero1Field.getText());
                int num2 = Integer.parseInt(numero2Field.getText());
                resultadoLabel.setText("Resultado: " + (num1 + num2));
            }
        });

        restarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(numero1Field.getText());
                int num2 = Integer.parseInt(numero2Field.getText());
                resultadoLabel.setText("Resultado: " + (num1 - num2));
            }
        });

        multiplicarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(numero1Field.getText());
                int num2 = Integer.parseInt(numero2Field.getText());
                resultadoLabel.setText("Resultado: " + (num1 * num2));
            }
        });

        dividirBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(numero1Field.getText());
                int num2 = Integer.parseInt(numero2Field.getText());
                if (num2 != 0) {
                    resultadoLabel.setText("Resultado: " + (num1 / num2));
                } else {
                    resultadoLabel.setText("Imposible dividir entre 0");
                }
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}