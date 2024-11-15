package com.alunos.controller;

import java.io.IOException;

import com.alunos.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class buscarNomeFXMLController {

    @FXML
    private Button voltarPrincipalButton;

    @FXML
    private Button buscarNomeButton;

    @FXML
    private TextField nomeTextField;

    @FXML
    private Text avisoText;

    @FXML
    void voltarPrincipal(ActionEvent event) throws IOException {
        principalFXMLController.setAviso("");
        App.setRoot("principal");
    }

    @FXML
    void buscarNome(ActionEvent event) throws IOException {
        if (nomeTextField.getText().length() == 0) {
            avisoText.setText("Por favor, preencha o nome do aluno.");
            return;
        }
        listaAlunosFXMLController.setTipoFiltro(listaAlunosFXMLController.FILTRO_NOME);
        listaAlunosFXMLController.setFiltro(nomeTextField.getText());
        App.setRoot("listaAlunos");
    }
}
