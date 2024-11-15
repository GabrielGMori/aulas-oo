package com.alunos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

import com.alunos.controller.escolaController;
import com.alunos.model.Aluno;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        scene = new Scene(loadFXML("principal"), 1200, 800);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() {
        Scanner scanner = new Scanner(System.in);

        clear();
        System.out.print("DADOS DA ESCOLA\n");
        String escolaNome;
        do {
            System.out.print("Nome: ");;
            escolaNome = scanner.nextLine();
        } while(escolaNome.length() == 0);
        String escolaTelefone;
        do {
            System.out.print("Telefone: ");
            escolaTelefone = scanner.nextLine();
        } while(format(escolaTelefone).length() != 11);
        clear();

        escolaController.setEscola(escolaNome, format(escolaTelefone));
        scanner.close();

        escolaController.getEscola().adicionarAluno(new Aluno("ana silva", "11111111112", "ana.silva@gmail.com", "14102007"));
        escolaController.getEscola().adicionarAluno(new Aluno("carlos oliveira", "22222222223", "carlos.oliveira@gmail.com", "12062006"));
        escolaController.getEscola().adicionarAluno(new Aluno("beatriz santos", "33333333334", "beatriz.santos@gmail.com", "23092008"));
        escolaController.getEscola().adicionarAluno(new Aluno("daniel costa", "44444444445", "daniel.costa@gmail.com", "31012007"));
        escolaController.getEscola().adicionarAluno(new Aluno("fernanda lima", "55555555556", "fernanda.lima@gmail.com", "05052005"));
        escolaController.getEscola().adicionarAluno(new Aluno("gabriel rocha", "66666666667", "gabriel.rocha@gmail.com", "20082007"));
        escolaController.getEscola().adicionarAluno(new Aluno("helena martins", "77777777778", "helena.martins@gmail.com", "18032006"));
        escolaController.getEscola().adicionarAluno(new Aluno("igor ferreira", "88888888889", "igor.ferreira@gmail.com", "09072008"));
        escolaController.getEscola().adicionarAluno(new Aluno("juliana almeida", "99999999990", "juliana.almeida@gmail.com", "21112007"));
        escolaController.getEscola().adicionarAluno(new Aluno("lucas souza", "10101010101", "lucas.souza@gmail.com", "15042006"));
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    private void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static String format(String string) {
        return string.trim().replace(" ", "").replace(".", "").replace("-", "").replace("/", "").replace("(", "").replace(")", "");
    }
}