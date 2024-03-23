package com.agendadorConsulta.service.impl;

import com.agendadorConsulta.domain.Colaborador;
import com.agendadorConsulta.service.RelatorioService;

import java.io.*;
import java.time.LocalDateTime;

public class RelatorioServiceImpl implements RelatorioService {

    private Colaborador colaborador;

    public RelatorioServiceImpl(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Relatório gerado com sucesso!");
        System.out.println("Relatório criado em: " + LocalDateTime.now());
        System.out.println("Colaborador selecionado:");
        System.out.println(colaborador.toString() + "\n");
        System.out.println("Pacientes do colaborador:");
        colaborador.listarPaciente();
    }


    public static void excluirRelatorio() {
        try {
            String arquivoBat = "excluirRelatorio.bat";
            ProcessBuilder builder = new ProcessBuilder(arquivoBat);

            builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectError(ProcessBuilder.Redirect.INHERIT);

            Process processo = builder.start();

            int exitCode = processo.waitFor();

            if (exitCode == 0)
                System.out.println("Executado com sucesso!");
            else
                System.out.println("Erro ao executar o arquivo .bat");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void gerarRelatorioTXT() throws FileNotFoundException {
        String fileName = "relatorio" + colaborador.getNome() + ".txt";
        OutputStream os = new FileOutputStream(fileName);
        try{
            Writer wr = new OutputStreamWriter(os);
            BufferedWriter arq = new BufferedWriter(wr);
            arq.write("Relatório de Dados de Pacientes\n");
            arq.newLine();
            arq.write("Relatório criado em: " + LocalDateTime.now() + "\n");
            arq.write("Colaborador selecionado:\n");
            arq.write(colaborador.toString() + "\n");
            arq.newLine();
            arq.write("Pacientes do colaborador:\n");
            colaborador.getPacientes().forEach(paciente -> {
                try {
                    arq.write(paciente.toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            arq.close();
            System.out.println("Relatório gerado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
