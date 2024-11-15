package com.alunos.controller;

import java.io.IOException;

import com.alunos.App;
import com.alunos.model.Aluno;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class adicionarAlunoFXMLController {

    @FXML
    private Button voltarPrincipalButton;

    @FXML
    private TextField nascimentoTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button adicionarAlunoButton;

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
    void adicionarAluno(ActionEvent event) throws IOException {
        if (nomeTextField.getText().trim().length() == 0 || cpfTextField.getText().trim().length() == 0 || emailTextField.getText().trim().length() == 0 || nascimentoTextField.getText().trim().length() == 0) {
            avisoText.setText("Por favor, preencha todos os campos.");
        } else if (emailTextField.getText().contains("@") == false) {
            avisoText.setText("E-mail inválido.");
        } else if (App.format(nascimentoTextField.getText()).length() != 8) {
            avisoText.setText("Data de nascimento inválida.");
        } else if (App.format(cpfTextField.getText()).length() != 11) {
            avisoText.setText("CPF inválido.");
        } else if (escolaController.getEscola().adicionarAluno(new Aluno(nomeTextField.getText(), cpfTextField.getText(), emailTextField.getText(), nascimentoTextField.getText())) == false) {
            avisoText.setText("Esse CPF já foi cadastrado.");
        } else {
            principalFXMLController.setAviso("Aluno cadastrado com sucesso!");
            App.setRoot("principal");
        }
    }
}
