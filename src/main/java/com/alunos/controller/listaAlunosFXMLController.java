package com.alunos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.alunos.App;
import com.alunos.model.Aluno;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class listaAlunosFXMLController implements Initializable {
    public static final Integer SEM_FILTRO = null;
    public static final Integer FILTRO_CPF = 0;
    public static final Integer FILTRO_NOME = 1;

    private static Integer tipoFiltro = null;
    private static String filtro = null;

    @FXML
    private Button voltarPrincipalButton;

    @FXML
    private Text listaAlunos;

    @FXML
    private Text pesquisaText;

    public void initialize(URL location, ResourceBundle resources) {
        String alunosString = null;
        if (tipoFiltro == SEM_FILTRO) {
            alunosString = escolaController.getEscola().listar();
        } else if (tipoFiltro == FILTRO_CPF) {
            pesquisaText.setText("Pesquisando por: " + filtro);
            Aluno alunoEncontrado = escolaController.getEscola().buscarAlunoCpf(filtro);
            if (alunoEncontrado != null) alunosString = alunoEncontrado.toString();
        } else if (tipoFiltro == FILTRO_NOME) {
            pesquisaText.setText("Pesquisando por: " + filtro);
            ArrayList<Aluno> alunosEncontrados = escolaController.getEscola().buscarAlunoNome(filtro);
            if (alunosEncontrados != null) {
                alunosString = "";
                for (int i=0; i<alunosEncontrados.size(); i++) {
                    if (i != 0) alunosString = alunosString + "\n\n";
                    alunosString = alunosString + alunosEncontrados.get(i).toString();
                }
            }
        }
        if (alunosString == null) {
            alunosString = "Nenhum aluno cadastrado";
            listaAlunos.setTextAlignment(TextAlignment.CENTER);
        }
        listaAlunos.setText(alunosString);
    }

    @FXML
    void voltarPrincipal(ActionEvent event) throws IOException {
        principalFXMLController.setAviso("");
        App.setRoot("principal");
    }

    public static void setTipoFiltro(Integer novoTipoFiltro) {
        tipoFiltro = novoTipoFiltro;
    }

    public static void setFiltro(String novoFiltro) {
        filtro = novoFiltro;
    }
}
