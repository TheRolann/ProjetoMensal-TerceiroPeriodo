package br.edu.uniamerica.projetomensal.menu;

import br.edu.uniamerica.projetomensal.model.Servico;
import br.edu.uniamerica.projetomensal.model.enums.Status;
import br.edu.uniamerica.projetomensal.service.ServicoService;

import java.util.List;
import java.util.Scanner;

public class ServicoMenu {

    private ServicoService servicoService = new ServicoService();
    // Scanner para entrada de dados
    Scanner sc = new Scanner(System.in);

    int opcao;

    public void iniciar() {

        do {
            System.out.println("________________________________________");
            System.out.println("| === === SISTEMA DETETIZADORA === === |");
            System.out.println("|  -- --- --- Menu Servico --- --- --  |");
            System.out.println("| 1 - Cadastar                         |");
            System.out.println("| 2 - Editar                           |");
            System.out.println("| 3 - Apagar                           |");
            System.out.println("| 4 - Listar                           |");
            System.out.println("| 0 - Voltar                           |");
            System.out.println("----------------------------------------");
            opcao = Integer.parseInt(sc.nextLine());

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
        System.out.println("|--------------------------------------|");
        System.out.println("|  --- --- Cadastro de Servico --- --- |");
        System.out.println("|--------------------------------------|");
        System.out.print("| Nome do Servico: ");
        String nomeServico = sc.nextLine();
        System.out.print("| Descrição do Servico (RESUMA): ");
        String descricao = sc.nextLine();
        System.out.print("| Data Agendada (DD/MM/AAAA): ");
        String data = sc.nextLine();
        System.out.print("| Valor do Servico: R$ ");
        double valor = Double.parseDouble(sc.nextLine().replace(",", "."));
        System.out.print("| ID do Cliente: ");
        int clienteID = Integer.parseInt(sc.nextLine());
        System.out.print("| Status do Servico (ATIVO/INATIVO): ");
        String statusInput = sc.nextLine();
        Status status = Status.valueOf(statusInput.toUpperCase());

        servicoService.cadastrar(nomeServico, descricao, data, valor, clienteID, status);
        System.out.println("| Servico cadastrado com sucesso!       |");
        System.out.println("|---------------------------------------|");
    }

    void listarServico() {
        List<Servico> servicos = servicoService.listar();

        System.out.println("|--------------------------------------|");
        System.out.println("|  --- --- Lista de Servicos --- ---   |");
        System.out.println("|--------------------------------------|");

        for (Servico c : servicos) {
            System.out.println("|--------------------------------------|");
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
        System.out.println("|--------------------------------------|");
        System.out.println("|    --- --- Excluir Servico --- ---   |");
        System.out.println("|--------------------------------------|");
        System.out.println("| Informe o ID do servico: ");
        int id = Integer.parseInt(sc.nextLine());
        servicoService.excluir(id);
        System.out.println("| Servico excluido com sucesso!         |");
        System.out.println("|---------------------------------------|");
    }

    void editarServico() {
        System.out.println("|--------------------------------------|");
        System.out.println("|    --- --- Editar Servico --- ---    |");
        System.out.println("|--------------------------------------|");
        System.out.println("| Informe o ID do servico: ");
        int id = Integer.parseInt(sc.nextLine());
        Servico servico = servicoService.buscarPorId(id);

        if(servico == null) {
            System.out.println("| ERRO! Servico nao encontrado.        |");
            System.out.println("|--------------------------------------|");
            return;
        }

        System.out.println("| Servico encontrado!                   |");
        System.out.println("| Nome do servico atual: " + servico.getNomeServico());
        System.out.println("| Novo nome do servico (ENTER para manter): ");
        String nomeServico = sc.nextLine();
        if (!nomeServico.isEmpty()) {
            servico.setNomeServico(nomeServico);
        }
        System.out.println("| Data atual: " + servico.getData());
        System.out.println("| Nova data (ENTER para manter): ");
        String data = sc.nextLine();
        if (!data.isEmpty()) {
            servico.setData(data);
        }
        System.out.println("| Valor atual: R$ " + servico.getValor());
        System.out.println("| Novo valor (ENTER para manter): ");
        double valor = sc.nextDouble();
        if (valor != 0 && valor != servico.getValor() && valor > 0) {
            servico.setValor(valor);
        } else if (valor < 0) {
            System.out.println("| Valor invalido. Mantendo valor atual. |");
        }

        System.out.println("| Status atual: " + servico.getStatus());
        System.out.println("| Novo Status (ATIVO/INATIVO) (ENTER para manter): ");
        String statusInput = sc.nextLine();
        if (!statusInput.isEmpty()) {
            Status status = Status.valueOf(statusInput.toUpperCase());
            servico.setStatus(status);
        }
        servicoService.editar(servico);
        System.out.println("| Servico atualizado com sucesso!       |");
        System.out.println("|---------------------------------------|");
    }
}
