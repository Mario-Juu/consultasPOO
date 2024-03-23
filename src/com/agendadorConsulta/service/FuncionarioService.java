package com.agendadorConsulta.service;

import com.agendadorConsulta.domain.Funcionario;

import java.util.Scanner;

public class FuncionarioService {

    public static Funcionario criarFuncionario(){
        Funcionario funcionario = new Funcionario();
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome do funcionário: ");
        funcionario.setNome(s.next());
        System.out.println("Digite o horário do funcionário: ");
        funcionario.setHorario(s.next());
        System.out.println("Digite a idade do funcionário: ");
        funcionario.setIdade(s.nextInt());
        System.out.println("Digite o ano de entrada do funcionário: ");
        funcionario.setAnoEntrada(s.nextInt());
        System.out.println("Digite o cargo do funcionário: ");
        funcionario.setCargo(s.next());
        System.out.println("Digite o sindicato do funcionário: ");
        funcionario.setSindicato(s.next());

        System.out.println("Funcionário criado com sucesso!");
        return funcionario;

    }
}
