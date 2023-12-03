package com.mycompany.quadraturagaussiana;

import static com.mycompany.quadraturagaussiana.Quadratura.quadraturaGaussiana;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Font;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

public class GUI extends JFrame {
  private JLabel label1, label2, label3, label4, label5, label6;
  private JTextField textField1, textField2, textField3, textField4, textField5, textField6;
  private final JButton button;

  private static double eval(String function, double x) {
    Expression e = new Expression(function, new Argument("x", x));
    return e.calculate();
  }

  public GUI() {
    setTitle("Quadratura Gaussiana");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 400);
    setLocationRelativeTo(null);

    label1 = new JLabel("Digite a função a ser integrada:");
    label1.setFont(new Font("Arial", Font.PLAIN, 14));
    label3 = new JLabel("Digite o limite superior:");
    label3.setFont(new Font("Arial", Font.PLAIN, 14));
    label2 = new JLabel("Digite o limite inferior:");
    label2.setFont(new Font("Arial", Font.PLAIN, 14));
    label5 = new JLabel("Digite a quantidade de pontos:");
    label5.setFont(new Font("Arial", Font.PLAIN, 14));
    label4 = new JLabel("");
    label4.setFont(new Font("Arial", Font.PLAIN, 14));
    label6 = new JLabel("\n");

    textField1 = new JTextField();
    textField2 = new JTextField();
    textField3 = new JTextField();
    textField4 = new JTextField();
    textField4.setEditable(false);
    textField5 = new JTextField();
    textField6 = new JTextField();
    textField6.setEditable(false);

    button = new JButton("Calcular");

    button.addActionListener((ActionEvent e) -> {
      String function = textField1.getText();
      double a = Double.parseDouble(textField2.getText());
      double b = Double.parseDouble(textField3.getText());
      double n = Double.parseDouble(textField5.getText());
      double resultado = quadraturaGaussiana(a, b, (int) n, x -> eval(function, x));
      textField4.setText(String.format("Resultado: %.6f", resultado));
      double erro = ((b - a) / 2) * Math.pow(10, -n);
      textField6.setText(String.format("Erro: %.6f", erro));
    });

    textField1.setColumns(50);
    textField2.setColumns(50);
    textField3.setColumns(50);
    textField4.setColumns(50);
    textField5.setColumns(50);
    textField6.setColumns(50);

    JPanel panel = new JPanel();
    panel.add(label1);
    panel.add(textField1);
    panel.add(label2);
    panel.add(textField2);
    panel.add(label3);
    panel.add(textField3);
    panel.add(label5);
    panel.add(textField5);
    panel.add(label6);
    panel.add(button);
    panel.add(label4);
    panel.add(textField4);
    panel.add(textField6);
    add(panel);
  }

}
