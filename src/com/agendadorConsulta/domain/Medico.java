
package com.agendadorConsulta.domain;

/**
 *
 * @author Lukcas
 */
public class Medico extends Colaborador {
    private String crm;
    private String clinica;
    private String especialidade;

    
    public Medico(String nome, String horario, int idade, int anoEntrada, String crm, String clinica, String especialidade) {

        super(nome, horario, idade, anoEntrada);
        setCrm(crm);
        setClinica(clinica);
        setEspecialidade(especialidade);
    }

    public Medico() {

    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        if(crm.length() != 9) {
            throw new IllegalArgumentException("CRM deve ter ao menos 9 dígitos");
        }
        this.crm = crm.substring(0, 7) + "-" + crm.substring(7);
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        if(clinica.isEmpty()) {
            throw new IllegalArgumentException("Clínica não pode ser vazia");
        }
        this.clinica = clinica;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        if(especialidade.isEmpty()) {
            throw new IllegalArgumentException("Especialidade não pode ser vazia");
        }
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCRM: " + this.crm +
                "\nClínica: " + this.clinica +
                "\nEspecialdiade: " + this.especialidade;
    }
    
}
