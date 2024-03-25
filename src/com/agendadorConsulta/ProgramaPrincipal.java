
package com.agendadorConsulta;

import com.agendadorConsulta.domain.Colaborador;
import com.agendadorConsulta.domain.Paciente;
import com.agendadorConsulta.service.FuncionarioService;
import com.agendadorConsulta.service.MedicoService;
import com.agendadorConsulta.service.PacienteService;
import com.agendadorConsulta.service.impl.RelatorioServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;


public class ProgramaPrincipal {

    static Scanner s = new Scanner(System.in);
    static List<Colaborador> colaboradores = new ArrayList<>();


    public static void main(String[] args) {
        int escolhaPrincipal;
        do {

            System.out.print("""

                    MENU PRINCIPAL
                    1 - Criar novo colaborador
                    2 - Visualizar colaborador
                    0 - Sair
                    Digite sua escolha:\s""");
            escolhaPrincipal = s.nextInt();
            switch (escolhaPrincipal) {

                case 1 -> criarColaborador();
                case 2 -> visualizarColaborador();
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

    public static void visualizarColaborador(){
        System.out.println("Visualizar colaborador");
        AtomicReference<Colaborador> colaborador = new AtomicReference<>();
        System.out.println("Digite o nome do colaborador: ");
        String nomeColaborador = s.next();

        colaboradores.stream().filter(value -> value.getNome().equalsIgnoreCase(nomeColaborador)).forEach(colaborador::set);
        if(colaborador.get() != null)
            System.out.println("Colaborador encontrado");
        else {
            System.out.println("Colaborador não encontrado");
            return;
        }


        System.out.println("Deseja visualizar os pacientes do colaborador? (1 - Sim / 2 - Não)");
        int visualizarPacientes = s.nextInt();
        if (visualizarPacientes == 1){
            RelatorioServiceImpl relatorio = new RelatorioServiceImpl(colaborador.get());
            relatorio.gerarRelatorio();
        }

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
                if(funcionario != null)
                    preencherColaborador(funcionario);
            }

            case 2 -> {
                Colaborador medico = MedicoService.criarMedico();
                if(medico != null)
                    preencherColaborador(medico);
            }
            default -> System.out.println("Opção inválida");
        }

    }

    private static void preencherColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
        criarPacientes(colaborador);
        System.out.println("Gerando relatório de consultas...");
        RelatorioServiceImpl relatorio = new RelatorioServiceImpl(colaborador);
        relatorio.gerarRelatorio();
        try{
            relatorio.gerarRelatorioTXT();
        } catch (Exception e) {
            e.printStackTrace();
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
