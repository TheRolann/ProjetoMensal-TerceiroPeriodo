package br.edu.uniamerica.projetomensal.menu;

import br.edu.uniamerica.projetomensal.model.Servico;
import br.edu.uniamerica.projetomensal.model.enums.Status;
import br.edu.uniamerica.projetomensal.service.ServicoService;
import br.edu.uniamerica.projetomensal.utils.InputUtils;

import java.util.List;
import java.util.Scanner;

public class ServicoMenu {
    private ServicoService servicoService = new ServicoService();
    // Scanner para entrada de dados
    Scanner sc = new Scanner(System.in);

    int opcao;

    public void iniciar() {

        do {
            System.out.println("\n|--------------------------------------|");
            System.out.println("| === === SISTEMA DETETIZADORA === === |");
            System.out.println("|  -- --- --- Menu Servico --- --- --  |");
            System.out.println("| 1 - Cadastar                         |");
            System.out.println("| 2 - Editar                           |");
            System.out.println("| 3 - Apagar                           |");
            System.out.println("| 4 - Listar                           |");
            System.out.println("| 0 - Voltar                           |");
            System.out.println("|--------------------------------------|");
            opcao = InputUtils.lerInt(sc,"Opcao: ");

            switch (opcao) {
                case 1:
                    cadastrarServico();
                    break;
                case 2:
                    editarServico();
                    break;
                case 3:
                    excluirServico();
                    break;
                case 4:
                    listarServico();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    void cadastrarServico() {
        System.out.println("\n|--------------------------------------|");
        System.out.println("|  --- --- Cadastro de Servico --- --- |");
        System.out.println("|--------------------------------------|");
        String nomeServico = InputUtils.lerString(sc, "| Nome do Servico: ");
        String descricao = InputUtils.lerString(sc, "| Descricao do Servico: ");
        String data = InputUtils.lerString(sc, "| Data Agendada (DD/MM/AAAA): ");
        double valor = InputUtils.lerDouble(sc, "| Valor do Servico: R$ ");
        int clienteID = InputUtils.lerInt(sc, "| ID do Cliente: ");
        System.out.println("| Status do Servico ");
        System.out.println("| 1 - ATIVO\n| 2 - INATIVO\n| 3 - AGENDADO\n| 4 - EM ANDAMENTO\n| 5 - CONCLUIDO");
        System.out.print("| Informe o numero do status: ");
        int statusInput = InputUtils.lerInt(sc, "");
        // Cria um array de Status do Enum e seleciona o status com base na entrada do usuario
        // ex: [ATIVO, INATIVO, AGENDADO, EM_ANDAMENTO, CONCLUIDO]
        Status status = Status.values()[statusInput - 1];

        Servico servico = servicoService.cadastrar(nomeServico, descricao, data, valor, clienteID, status);
        System.out.println("\n|---------------------------------------|");
        System.out.println("| Servico cadastrado com sucesso!       |");
        System.out.println("| ID do Servico: " + servico.getId() + "        \t\t|");
        System.out.println("|---------------------------------------|");
    }

    void listarServico() {
        List<Servico> servicos = servicoService.listar();

        System.out.println("\n|--------------------------------------|");
        System.out.println("|  --- --- Lista de Servicos --- ---   |");
        System.out.println("|--------------------------------------|");

        for (Servico c : servicos) {
            System.out.println("\n|--------------------------------------|");
            System.out.println("| ID: " + c.getId() + "\t |");
            System.out.println("| Nome do Servico: " + c.getNomeServico() + "\t |");
            System.out.println("| Descricao: " + c.getDescricao() + "\t |");
            System.out.println("| Data: " + c.getData() + "\t |");
            System.out.println("| Valor: R$ " + c.getValor() + "\t |");
            System.out.println("| ID do Cliente: " + c.getClienteID() + "\t |");
            System.out.println("| Status: " + c.getStatus() + "\t |");
            System.out.println("|--------------------------------------|");
        }
    }

    void excluirServico() {
        System.out.println("\n|--------------------------------------|");
        System.out.println("|    --- --- Excluir Servico --- ---   |");
        System.out.println("|--------------------------------------|");
        System.out.print("| Informe o ID do servico: ");
        int id = InputUtils.lerInt(sc, "");
        servicoService.excluir(id);
        System.out.println("|---------------------------------------|");
        System.out.println("| Servico excluido com sucesso!         |");
        System.out.println("|---------------------------------------|");
    }

    void editarServico() {
        System.out.println("\n|--------------------------------------|");
        System.out.println("|    --- --- Editar Servico --- ---    |");
        System.out.println("|--------------------------------------|");
        System.out.print("| Informe o ID do servico: ");
        int id = InputUtils.lerInt(sc, "");
        Servico servico = servicoService.buscarPorId(id);

        if(servico == null) {
            System.out.println("|--------------------------------------|");
            System.out.println("| ERRO! Servico nao encontrado.        |");
            System.out.println("|--------------------------------------|");
            return;
        }
        System.out.println("|--------------------------------------|");
        System.out.println("| Servico encontrado!                  |");
        System.out.println("| Nome do servico atual: " + servico.getNomeServico());
        System.out.print("| Novo nome do servico (ENTER para manter): ");
        String nomeServico = InputUtils.lerString(sc, "");
        if (!nomeServico.isEmpty()) {
            servico.setNomeServico(nomeServico);
        }
        System.out.println("| Data atual: " + servico.getData());
        System.out.print("| Nova data (ENTER para manter): ");
        String data = InputUtils.lerString(sc, "");
        if (!data.isEmpty()) {
            servico.setData(data);
        }
        System.out.println("| Valor atual: R$ " + servico.getValor());
        System.out.print("| Novo valor (ENTER para manter): R$ ");
        double valor = InputUtils.lerDouble(sc, "");
        if (valor != 0 && valor != servico.getValor() && valor > 0) {
            servico.setValor(valor);
        } else if (valor < 0 || valor == servico.getValor()) {
            System.out.println("| Valor invalido. Mantendo valor atual. |");
        }

        System.out.println("| Status atual: " + servico.getStatus());
        System.out.println("| Novo Status");
        System.out.println("| 1 - ATIVO\n| 2 - INATIVO\n| 3 - AGENDADO\n| 4 - EM ANDAMENTO\n| 5 - CONCLUIDO");
        System.out.print("| Informe o numero do status (ENTER para manter): ");
        int statusInput = InputUtils.lerInt(sc, "");
        if (statusInput > 0 && statusInput <= Status.values().length) {
            Status status = Status.values()[statusInput - 1];
            servico.setStatus(status);
        } else if (statusInput != 0) {
            System.out.println("| Status invalido. Mantendo status atual. |");
        }
        servicoService.editar(servico);
        System.out.println("|---------------------------------------|");
        System.out.println("| Servico atualizado com sucesso!       |");
        System.out.println("|---------------------------------------|");
    }
}
