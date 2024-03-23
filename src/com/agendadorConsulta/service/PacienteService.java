package com.agendadorConsulta.service;

import com.agendadorConsulta.domain.Paciente;

import java.util.Scanner;

public class PacienteService {

    public static Paciente criarPaciente(){
        Paciente paciente = new Paciente();
        try{
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome do paciente: ");
        paciente.setNome(s.next());
        System.out.println("Digite a data de nascimento do paciente: ");
        paciente.setDataNascimento(s.next());
        System.out.println("Digite o cpf do paciente: (Deve ter 11 digitos)");
        paciente.setCpf(s.next());
        System.out.println("Digite o telefone do paciente (deve ter 11 digitos): ");
        paciente.setTelefone(s.next());
        System.out.println("Digite o horário da consulta do paciente: ");
        paciente.setHorarioConsulta(s.next());
        } catch (IllegalArgumentException e){
            System.out.println("Erro ao criar o paciente: " + e.getMessage());
            System.out.println("Tente novamente.");
            return null;
        }

        System.out.println("Paciente criado com sucesso!");
        return paciente;
    }

}
