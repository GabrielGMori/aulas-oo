package com.alunos.controller;

import com.alunos.App;
import com.alunos.model.Escola;

public class escolaController {
    private static Escola escola;

    public static Escola getEscola() {
        return escola;
    }

    public static void setEscola(String nome, String telefone) {
        String telefoneFormatado = "("+App.format(telefone).substring(0, 2)+") "+App.format(telefone).substring(2, 7)+"-"+App.format(telefone).substring(7);
        escola = new Escola(nome.toUpperCase(), telefoneFormatado);
    }
}