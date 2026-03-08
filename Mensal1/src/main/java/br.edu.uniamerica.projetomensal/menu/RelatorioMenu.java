package br.edu.uniamerica.projetomensal.menu;

import br.edu.uniamerica.projetomensal.relatorio.RelatorioCliente;
import br.edu.uniamerica.projetomensal.relatorio.RelatorioServico;
import br.edu.uniamerica.projetomensal.service.ClienteService;
import br.edu.uniamerica.projetomensal.utils.InputUtils;

import java.util.Scanner;

public class RelatorioMenu {
    int opcao;

    Scanner sc = new Scanner(System.in);

    private RelatorioCliente relatorioCliente = new RelatorioCliente();
    private RelatorioServico relatorioServico = new RelatorioServico();


    public void iniciar() {
        do {
            System.out.println("\n|--------------------------------------|");
            System.out.println("| === === SISTEMA DETETIZADORA === === |");
            System.out.println("|  - --- --- Menu Relatorio --- --- -  |");
            System.out.println("|                                      |");
            System.out.println("| 1 - Relatorio de Cliente             |");
            System.out.println("| 2 - Relatorio de Funcionario         |");
            System.out.println("| 3 - Relatorio de Servico             |");
            System.out.println("| 0 - Voltar                           |");
            System.out.println("|--------------------------------------|");
            opcao = InputUtils.lerInt(sc, "Opcao: ");

            switch (opcao) {
                case 1:
                    relatorioCliente.totalClientes();
                    break;
                case 2:

                case 3:
                    relatorioServico.totalFaturado();
                    break;
            }
        } while (opcao != 0);

    }
}