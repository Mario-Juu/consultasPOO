
package com.agendadorConsulta.domain;

public class Paciente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;

    private String horarioConsulta;

    
    public Paciente(String nome, String cpf, String dataNascimento, String telefone) {
        setNome(nome);
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        setTelefone(telefone);
    }

    public Paciente() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf.length() != 11){
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos");}
        this.cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        if(dataNascimento.isEmpty()) {
            throw new IllegalArgumentException("Data de nascimento não pode ser vazia");
        }
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone.length() != 11) {
            throw new IllegalArgumentException("O telefone deve ter 11 dígitos");
        }
        this.telefone = "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7);
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        if(horarioConsulta.isEmpty()) {
            throw new IllegalArgumentException("Horário da consulta não pode ser vazio");
        }
        this.horarioConsulta = horarioConsulta;
    }

    public String toString(){

        return "Nome: " + this.nome +
                "\nCPF: " + this.cpf +
                "\nData de nascimento: " + this.dataNascimento +
                "\nTelefone: " + this.telefone;
    }
}
