package com.agendadorConsulta.service;

import com.agendadorConsulta.domain.Medico;

import java.util.Scanner;

public class MedicoService {


    public static Medico criarMedico(){
        Medico medico = new Medico();
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome do médico: ");
        medico.setNome(s.next());
        System.out.println("Digite o horário do médico: ");
        medico.setHorario(s.next());
        System.out.println("Digite a idade do médico: ");
        medico.setIdade(s.nextInt());
        System.out.println("Digite o ano de entrada do médico: ");
        medico.setAnoEntrada(s.nextInt());
        System.out.println("Digite a especialidade do médico: ");
        medico.setEspecialidade(s.next());
        System.out.println("Digite o CRM do médico (deve ter 9 digitos): ");
        medico.setCrm(s.next());
        System.out.println("Digite a clínica do médico: ");
        medico.setClinica(s.next());

        System.out.println("Médico criado com sucesso!");
        return medico;
    }
}
