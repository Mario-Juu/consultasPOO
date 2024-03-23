package com.agendadorConsulta.service;

import java.io.IOException;

public interface RelatorioService {
    void gerarRelatorio();
    void gerarRelatorioTXT() throws IOException;

    static void excluirRelatorio() {

    }
}
