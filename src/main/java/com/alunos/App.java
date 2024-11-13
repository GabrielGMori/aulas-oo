package com.alunos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.alunos.model.Aluno;
import com.alunos.model.Escola;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        // stage.show();
    }

    @Override
    public void init() {
        Scanner scanner = new Scanner(System.in);

        clear();
        System.out.print("DADOS DA ESCOLA\nNome: ");
        String escolaNome = scanner.nextLine();
        System.out.print("Telefone: ");
        String escolaTelefone = scanner.nextLine();
        clear();
        
        Escola escola = new Escola(escolaNome, escolaTelefone);
        printMenu(escola);

        int escolha = 0;
        do {    
            System.out.print("\n> ");
            escolha = scanner.nextInt();
            scanner = new Scanner(System.in);
            clear();
            switch(escolha) {
                case 1:
                    System.out.print("ADICIONAR ALUNO\nNome: ");
                    String alunoNome = scanner.nextLine();
                    String alunoCpf;
                    do {
                        System.out.print("CPF: ");
                        alunoCpf = scanner.nextLine();
                    } while(format(alunoCpf).length() != 11);
                    System.out.print("E-mail: ");
                    String alunoEmail = scanner.nextLine();
                    String alunoNascimento;
                    do {
                        System.out.print("Nascimento (DD/MM/AAAA): ");
                        alunoNascimento = scanner.nextLine();
                    } while(format(alunoNascimento).length() != 8);
                    clear();
                    printMenu(escola);
                    if (escola.adicionarAluno(new Aluno(alunoNome, alunoCpf, alunoEmail, alunoNascimento)) == false) {
                        System.out.println("\nCpf já registrado");
                        break;
                    }
                    System.out.println("\nAluno criado com sucesso");
                    break;
                case 2:
                    System.out.print("PESQUISAR POR NOME\nNome: ");
                    String pesquisaNome = scanner.nextLine();
                    ArrayList<Aluno> alunosEncontrados = escola.buscarAlunoNome(pesquisaNome);
                    clear();
                    System.out.println("ALUNOS ENCONTRADOS\n");
                    if (alunosEncontrados == null) {
                        System.out.println("Nenhum aluno encontrado\n");
                    } else {
                        for (int i=0; i<alunosEncontrados.size(); i++) {
                            System.out.print(alunosEncontrados.get(i).toString());
                        }
                    }
                    System.out.print("Pressione ENTER para sair");
                    scanner.nextLine();
                    clear();
                    printMenu(escola);
                    break;

                case 3:
                    
                    System.out.println("PESQUISAR POR CPF");
                    String pesquisaCpf;
                    do {
                        System.out.print("CPF: ");
                        pesquisaCpf = scanner.nextLine();
                    } while(format(pesquisaCpf).length() != 11);
                    Aluno alunoEncontrado = escola.buscarAlunoCpf(pesquisaCpf);
                    clear();
                    System.out.println("ALUNOS ENCONTRADOS\n");
                    if (alunoEncontrado == null) {
                        System.out.println("Nenhum aluno encontrado\n");
                    } else {
                        System.out.print(alunoEncontrado.toString());
                    }
                    System.out.print("Pressione ENTER para sair");
                    scanner.nextLine();
                    clear();
                    printMenu(escola);
                    break;
                
                case 4:
                    System.out.print("REMOVER ALUNO\nCPF: ");
                    String removerCPF = scanner.nextLine();
                    boolean sucesso = escola.removerAluno(removerCPF);
                    clear();
                    printMenu(escola);
                    if (sucesso == false) {
                        System.out.println("\nCpf não encontrado");
                        break;
                    }
                    System.out.println("\nAluno removido com sucesso");
                    break;

                case 5:
                    String alunos = escola.listar();
                    if (alunos == null) alunos = "Nenhum aluno registrado\n\n";
                    System.out.print("LISTA DE ALUNOS\n\n" + alunos + "Pressione ENTER para sair");
                    scanner.nextLine();
                    clear();
                    printMenu(escola);
                    break;
                
                case 0:
                    System.out.println("PROGRAMA FINALIZADO");
                    break;
                
                default:
                    printMenu(escola);
                    System.out.println("\nEscolha inválida");
                    break;
            }
        } while (escolha != 0);

        scanner.close();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    private void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    private void printMenu(Escola escola) {
        System.out.println(escola.getNome() + "\n\nGerenciamento de alunos\n1) Adicionar aluno\n2) Buscar aluno por nome\n3) Buscar aluno por CPF\n4) Remover aluno\n5) Listar alunos\n0) Sair\n\nContato: "+escola.getTelefone());
    }

    public static String format(String string) {
        return string.trim().replace(" ", "").replace(".", "").replace("-", "").replace("/", "");
    }
}