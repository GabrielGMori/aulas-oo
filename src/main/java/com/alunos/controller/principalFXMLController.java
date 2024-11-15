package com.alunos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.alunos.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class principalFXMLController implements Initializable {
    private static String aviso = "";

    @FXML
    private Button buscarCpf;

    @FXML
    private Text escolaTelefoneText;

    @FXML
    private Button buscarNomeButton;

    @FXML
    private Button listarAlunosButton;

    @FXML
    private Button adicionarAlunoButton;

    @FXML
    private Text escolaNomeText;

    @FXML
    private Button removerAlunoButton;

    @FXML
    private Text avisoText;

    public void initialize(URL location, ResourceBundle resources) {
        escolaNomeText.setText(escolaController.getEscola().getNome());
        escolaTelefoneText.setText("Contato: " + escolaController.getEscola().getTelefone());
        avisoText.setText(aviso);
    }

    @FXML
    void listarAlunos(ActionEvent event) throws IOException {
        listaAlunosFXMLController.setTipoFiltro(listaAlunosFXMLController.SEM_FILTRO);
        App.setRoot("listaAlunos");
    }

    @FXML
    void adicionarAluno(ActionEvent event) throws IOException {
        App.setRoot("adicionarAluno");
    }

    @FXML
    void removerAluno(ActionEvent event) throws IOException {
        App.setRoot("removerAluno");
    }

    @FXML
    void buscarNome(ActionEvent event) throws IOException {
        App.setRoot("buscarNome");
    }

    @FXML
    void buscarCpf(ActionEvent event) throws IOException {
        App.setRoot("buscarCpf");
    }

    public static void setAviso(String novoAviso) {
        aviso = novoAviso;
    }

}
