package br.edu.uniamerica.projetomensal.relatorio;

import br.edu.uniamerica.projetomensal.model.Servico;
import br.edu.uniamerica.projetomensal.service.ServicoService;

public class RelatorioServico {

    private ServicoService servicoService = new ServicoService();

    public void totalFaturado() {
        double total = 0;

        for (Servico s : servicoService.listar()) {
            total += s.getValor();
        }

        System.out.println("\n|--------------------------------------|");
        System.out.println("|   --- --- Relatorio Servico --- ---  |");
        System.out.printf("| Total Faturado: R$ %.2f             |\n", total);
        System.out.println("|--------------------------------------|");
    }
}
