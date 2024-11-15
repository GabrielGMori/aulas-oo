package com.alunos.controller;

import java.io.IOException;

import com.alunos.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class buscarCpfFXMLController {

    @FXML
    private Button buscarCpfButton;

    @FXML
    private Button voltarPrincipalButton;

    @FXML
    private Text avisoText;

    @FXML
    private TextField cpfTextField;

    @FXML
    void voltarPrincipal(ActionEvent event) throws IOException {
        principalFXMLController.setAviso("");
        App.setRoot("principal");
    }

    @FXML
    void buscarCpf(ActionEvent event) throws IOException {
        if (verificarCpf(cpfTextField.getText()) == true) {
            listaAlunosFXMLController.setTipoFiltro(listaAlunosFXMLController.FILTRO_CPF);
            listaAlunosFXMLController.setFiltro(cpfTextField.getText());
            App.setRoot("listaAlunos");
        }
    }

    private boolean verificarCpf(String cpf) {
        if (cpf.length() == 0) {
            avisoText.setText("Por favor, preencha o CPF do aluno.");
            return false;
        } else if (cpf.length() != 11) {
            avisoText.setText("CPF inválido."); 
            return false;
        }
        avisoText.setText("");
        return true;
    }
}
