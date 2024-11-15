package com.alunos.controller;

import java.io.IOException;

import com.alunos.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class removerAlunoFXMLController {
    private boolean confirmacao = false;

    @FXML
    private Button buscarCpfButton;

    @FXML
    private Button voltarPrincipalButton;

    @FXML
    private Text avisoText;

    @FXML
    private TextField cpfTextField;

    @FXML
    private Button removerAlunoButton;

    @FXML
    private Label alunoBuscadoText;

    @FXML
    void buscarCpf(ActionEvent event) {
        confirmacao = false;
        if (verificarCpf(App.format(cpfTextField.getText())) == true) {
            alunoBuscadoText.setText(escolaController.getEscola().buscarAlunoCpf(App.format(cpfTextField.getText())).toString());
        }
    }

    @FXML
    void voltarPrincipal(ActionEvent event) throws IOException {
        principalFXMLController.setAviso("");
        App.setRoot("principal");
    }

    @FXML
    void removerAluno(ActionEvent event) throws IOException {
        if (confirmacao == false) {
            confirmacao = true;
            avisoText.setText("Clique novamente para confirmar.\n(Isso deletará permanentemente o aluno!)");
            return;
        } else if (verificarCpf(App.format(cpfTextField.getText())) == true) {
            escolaController.getEscola().removerAluno(App.format(cpfTextField.getText()));
            principalFXMLController.setAviso("Aluno removido com sucesso!");
            App.setRoot("principal");
        } else {
            confirmacao = false;
        }
    }

    private boolean verificarCpf(String cpf) {
        if (cpf.length() == 0) {
            avisoText.setText("Por favor, preencha o CPF do aluno.");
            return false;
        } else if (cpf.length() != 11) {
            avisoText.setText("CPF inválido."); 
            return false;
        } else if (escolaController.getEscola().buscarAlunoCpf(cpf) == null) {
            avisoText.setText("O CPF digitado não corresponde\na nenhum aluno cadastrado.");
            return false;
        }
        avisoText.setText("");
        return true;
    }
}
