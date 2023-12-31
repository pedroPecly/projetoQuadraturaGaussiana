package controller;

import javax.swing.*;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import static model.Quadratura.quadraturaGaussiana;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PrincipalController extends JFrame {
    private JLabel labelFunction, labelLowerLimit, labelUpperLimit, labelNumPoints, labelResult, labelError;
    private JTextField textFieldFunction, textFieldLowerLimit, textFieldUpperLimit, textFieldNumPoints, textFieldResult,
            textFieldError;
    private final JButton button;

    private static double eval(String function, double x) {
        Expression e = new Expression(function, new Argument("x", x));
        return e.calculate();
    }

    public PrincipalController() {
        setTitle("Quadratura Gaussiana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        labelFunction = new JLabel("Função a ser integrada:");
        labelLowerLimit = new JLabel("Limite inferior:");
        labelUpperLimit = new JLabel("Limite superior:");
        labelNumPoints = new JLabel("Quantidade de pontos:");
        labelResult = new JLabel("Resultado:");
        labelError = new JLabel("Erro:");

        textFieldFunction = new JTextField();
        textFieldLowerLimit = new JTextField();
        textFieldUpperLimit = new JTextField();
        textFieldNumPoints = new JTextField();
        textFieldResult = new JTextField();
        textFieldResult.setEditable(false);
        textFieldError = new JTextField();
        textFieldError.setEditable(false);

        button = new JButton("Calcular");
        button.addActionListener((ActionEvent e) -> {
            try {
                String function = textFieldFunction.getText();
                double a = Double.parseDouble(textFieldLowerLimit.getText());
                double b = Double.parseDouble(textFieldUpperLimit.getText());
                Integer n = Integer.parseInt(textFieldNumPoints.getText());
        
                double resultado = quadraturaGaussiana(a, b, n, x -> eval(function, x));
                textFieldResult.setText(String.format("%.6f", resultado));
        
                double erro = ((b - a) / 2) * Math.pow(10, -n);
                textFieldError.setText(String.format("%.6f", erro));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(PrincipalController.this, "Erro de formato. Verifique os valores inseridos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(PrincipalController.this, "Ocorreu um erro durante o cálculo.", "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        panel.add(labelFunction);
        panel.add(textFieldFunction);
        panel.add(labelLowerLimit);
        panel.add(textFieldLowerLimit);
        panel.add(labelUpperLimit);
        panel.add(textFieldUpperLimit);
        panel.add(labelNumPoints);
        panel.add(textFieldNumPoints);
        panel.add(labelResult);
        panel.add(textFieldResult);
        panel.add(labelError);
        panel.add(textFieldError);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(button);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
