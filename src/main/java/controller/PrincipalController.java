/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class PrincipalController implements Initializable {

    @FXML
    private TextField txtFuncao;
    @FXML
    private TextField txtLimInferior;
    @FXML
    private TextField txtLimSuperior;
    @FXML
    private TextField txtNumPontos;
    @FXML
    private Button btnCalcular;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnCalcularOnAction(ActionEvent event) {
    }


}
