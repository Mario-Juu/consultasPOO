
package com.agendadorConsulta.domain;

import com.agendadorConsulta.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Lukcas
 */
public abstract class Colaborador {
    private String nome;
    private String horario;
    private int idade;
    private int anoEntrada;

    private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    
    
    public Colaborador(String nome, String horario, int idade, int anoEntrada) {
        
        setNome(nome);
        setHorario(horario);
        setIdade(idade);
        setAnoEntrada(anoEntrada);
        this.pacientes = new ArrayList<>();
    }

    
    public Colaborador() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        if(horario.isEmpty() ) {
            throw new IllegalArgumentException("Horário não pode ser vazio");
        }
        this.horario = horario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade < 0 || idade >= 18) {
            throw new IllegalArgumentException("Idade não pode ser negativa e o colaborador não pode ser de menor");}
        this.idade = idade;
    }


    public int getAnoEntrada() {
        return anoEntrada;
    }

    public void setAnoEntrada(int anoEntrada) {
        if(anoEntrada < 0)
            throw new IllegalArgumentException("Ano de entrada não pode ser negativo");
        this.anoEntrada = anoEntrada;
    }

    public void addPaciente(Paciente paciente) {
        if(paciente != null) {
            this.pacientes.add(paciente);
            return;
        }
        throw new IllegalArgumentException("Paciente não pode ser nulo");

    }

    public void removePaciente(String nome) {
        pacientes.removeIf(paciente -> paciente.getNome().equals(nome));
    }

    public void listarPaciente(){
        if(pacientes.size() == 0){
            throw new ResourceNotFoundException("Nenhum paciente cadastrado");
        }
        pacientes
                .forEach(e -> System.out.println(e.toString() + "\n"));
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void listarPaciente(String nome){
        Stream<Paciente> streamPacientes = pacientes.stream()
                .filter(paciente -> paciente.getNome().equals(nome));
        if (streamPacientes.findAny().isPresent()){
            streamPacientes.forEach(System.out::println);
            return;
        }
        throw new ResourceNotFoundException("Paciente não encontrado");

    }


    @Override
    public String toString(){

        return "Nome: " + this.nome +
                "\nHorário: " + this.horario +
                "\nIdade: " + this.idade +
                "\nAno de entrada: " + this.anoEntrada;
    }
    
}
