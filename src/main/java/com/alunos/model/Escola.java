package com.alunos.model;

import java.util.ArrayList;

import com.alunos.App;

public class Escola {
    private String nome;
    private String telefone;
    private ArrayList<Aluno> alunos;

    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.alunos =  new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean adicionarAluno(Aluno a) {
        if (buscarAlunoCpf(a.getCpf()) != null) {
            return false;
        }
        alunos.add(a);
        return true;
    }

    public ArrayList<Aluno> buscarAlunoNome(String nome) {
        ArrayList<Aluno> alunosEncontrados = new ArrayList<>();
        for (int i=0; i<alunos.size(); i++) {
            if (alunos.get(i).getNome().toLowerCase().contains(nome.toLowerCase())) {
                alunosEncontrados.add(alunos.get(i));
            }
        }
        if (alunosEncontrados.size() == 0) alunosEncontrados = null;
        return alunosEncontrados;
    }

    public Aluno buscarAlunoCpf(String cpf) {
        Aluno alunoEncontrado = null;
        for (int i=0; i<alunos.size(); i++) {
            if (App.format(alunos.get(i).getCpf()).compareTo(App.format(cpf)) == 0) {
                alunoEncontrado = alunos.get(i);
                break;
            }
        }
        return alunoEncontrado;
    }

    public boolean removerAluno(String cpf) {
        Aluno aluno = buscarAlunoCpf(cpf);
        if (aluno == null) {
            return false;
        }
        alunos.remove(aluno);
        return true;
    }

    public String listar() {
        String dados = "";
        for (int i=0; i<alunos.size(); i++) {
            dados = dados + alunos.get(i).toString();
        }
        if (dados == "") {
            dados = null;
        }
        return dados;
    }
    
}
