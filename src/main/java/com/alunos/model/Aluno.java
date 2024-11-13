package com.alunos.model;

import com.alunos.App;

public class Aluno {

    private String nome;
    private String cpf;
    private String email;
    private String nascimento;
    
    public Aluno(String nome, String cpf, String email, String nascimento) {
        this.nome = nome;
        this.cpf = App.format(cpf).substring(0, 3) + "." + App.format(cpf).substring(3, 6) + "." + App.format(cpf).substring(6, 9) + "-" + App.format(cpf).substring(9, 11);
        this.email = email;
        this.nascimento = App.format(nascimento).substring(0, 2) + "/" + App.format(nascimento).substring(2, 4) + "/" + App.format(nascimento).substring(4, 8);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String toString() {
        return nome+"\n- CPF: "+cpf+"\n- E-mail: "+email+"\n- Nascimento: "+nascimento+"\n\n";
    }
    
}
