
package com.agendadorConsulta;

import com.agendadorConsulta.domain.Colaborador;
import com.agendadorConsulta.domain.Paciente;
import com.agendadorConsulta.service.FuncionarioService;
import com.agendadorConsulta.service.MedicoService;
import com.agendadorConsulta.service.PacienteService;
import com.agendadorConsulta.service.impl.RelatorioServiceImpl;

import java.util.Scanner;


public class ProgramaPrincipal {

    static Scanner s = new Scanner(System.in);


    public static void main(String[] args) {
        int escolhaPrincipal;
        do {

            System.out.print("""

                    MENU PRINCIPAL
                    1 - Criar novo colaborador
                    0 - Sair
                    Digite sua escolha:\s""");
            escolhaPrincipal = s.nextInt();
            switch (escolhaPrincipal) {

                case 1 -> criarColaborador();
                case 0 -> {System.out.println("Deseja manter os relatórios? (1 - Sim / 2 - Não)");
                    int manterRelatorios = s.nextInt();
                    if (manterRelatorios == 2){
                        RelatorioServiceImpl.excluirRelatorio();
                    }
                    }
                default -> System.out.println("Opção inválida");
            }
        }
            while (escolhaPrincipal != 0);

        }


    public static void criarColaborador() {

        System.out.println("\nCOLABORADOR");

        System.out.println("Escolha abaixo qual tipo de colaborador será cadastrado" +
                "\n1 - Funcionário" +
                "\n2 - Médico");
        System.out.print("Digite sua opção: ");
        int escolhaColaborador = s.nextInt();

        switch (escolhaColaborador) {

            case 1 -> {
                Colaborador funcionario = FuncionarioService.criarFuncionario();
                criarPacientes(funcionario);
                System.out.println("Gerando relatório de consultas...");
                RelatorioServiceImpl relatorio = new RelatorioServiceImpl(funcionario);
                relatorio.gerarRelatorio();
                try{
                    relatorio.gerarRelatorioTXT();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            case 2 -> {
                Colaborador medico = MedicoService.criarMedico();
                criarPacientes(medico);
                System.out.println("Gerando relatório de consultas...");
                RelatorioServiceImpl relatorio = new RelatorioServiceImpl(medico);
                relatorio.gerarRelatorio();
                try{
                    relatorio.gerarRelatorioTXT();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            default -> System.out.println("Opção inválida");
        }

    }
    public static void criarPacientes(Colaborador colaborador){
        System.out.println("Adicione os pacientes ao colaborador");
        int criarNovoPaciente;
        do{
            Paciente paciente = PacienteService.criarPaciente();
            colaborador.addPaciente(paciente);
            System.out.println("Deseja criar outro?\nSim - 1\nNão - 2");
            criarNovoPaciente = s.nextInt();
        }
        while(criarNovoPaciente == 1);
    }




}
