
package com.agendadorConsulta.domain;

/**
 *
 * @author Lukcas
 */
public class Funcionario extends Colaborador {
    private String cargo;
    private String sindicato;

   
    public Funcionario(String nome, String horario, int idade, int anoEntrada, String cargo, String sindicato) {
        super(nome, horario, idade, anoEntrada);
        setCargo(cargo);
        setSindicato(sindicato);
    }

    public Funcionario() {

    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if(cargo.isEmpty()) {
            throw new IllegalArgumentException("Cargo não pode ser vazio");
        }
        this.cargo = cargo;
    }

    public String getSindicato() {
        return sindicato;
    }

    public void setSindicato(String sindicato) {
        if(sindicato.isEmpty()) {
            throw new IllegalArgumentException("Sindicato não pode ser vazio");
        }
        this.sindicato = sindicato;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCargo: " + this.cargo +
                "\nSindicato: " + this.sindicato;
    }
}
