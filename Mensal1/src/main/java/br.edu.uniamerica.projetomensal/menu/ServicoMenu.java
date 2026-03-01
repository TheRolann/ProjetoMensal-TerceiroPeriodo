package br.edu.uniamerica.projetomensal.menu;

import br.edu.uniamerica.projetomensal.model.Servico;
import br.edu.uniamerica.projetomensal.service.ServicoService;

import java.util.Scanner;

public class ServicoMenu {

    private ServicoService servicoService = new ServicoService();

    // Scanner para entrada de dados
    Scanner s = new Scanner(System.in);

    void menuServicoPrincipal(){
        System.out.println("=== GERENCIAR SERVIÇOS ===\n");
        System.out.println("1 - Cadastrar Serviço\n");
        System.out.println("2 - Listar Serviços\n");
        System.out.println("3 - Atualizar Serviço\n");
        System.out.println("4 - Remover Serviço\n");
        System.out.println("0 - Voltar\n");
        System.out.println("Escolha uma opção:  ");

    }

    void cadastrarServico(){
        System.out.println("=== Cadastro de Serviço ===\n");
        System.out.println("Tipo de Serviço: ");
        String nome = s.nextLine();
        System.out.println("Descrição: ");
        String descricao = s.nextLine();
        System.out.println("Data Agendada (dd/mm/aaaa): ");
        String data = s.nextLine();
        System.out.println("Valor: ");
        double valor = Double.parseDouble(s.nextLine());
        System.out.println("ID do Cliente: ");
        int clienteID = Integer.parseInt(s.nextLine());
        System.out.println("Status: (Agendado / Em andamento / Concluído): ");
        String status = s.nextLine();

        servicoService.cadastrar(nome, descricao, data, valor, clienteID, status);
        System.out.println("=== Serviço cadastrado com sucesso! ===");
    }

    void atualizarServico(){
        System.out.println("=== Atualizar Serviço ===");
        System.out.println("Informe o ID do serviço: ");
        int servicoID = Integer.parseInt(s.nextLine());
        Servico tipoServico = servicoService.buscarPorId(servicoID);
        if (tipoServico == null){
            System.out.println("Serviço não encontrado.");
            System.out.println("=== Retornando ao menu... ===");
            return;
        }
        System.out.println("Serviço encontrado!");
        System.out.println("Tipo atual: " + tipoServico.getNomeServico());
        System.out.println("Novo Tipo (ENTER para manter):");
        String nome = s.nextLine();
        if (!nome.isEmpty()){
            tipoServico.setNomeServico(nome);
        }

        System.out.println("Descrição atual: " + tipoServico.getDescricao());
        System.out.println("Nova Descrição (ENTER para manter):");
        String descricao = s.nextLine();
        if (!descricao.isEmpty()){
            tipoServico.setDescricao(descricao);
        }
        System.out.println("Data atual: " + tipoServico.getData());
        System.out.println("Nova Data (ENTER para manter):");
        String data = s.nextLine();
        if (!data.isEmpty()){
            tipoServico.setData(data);
        }
        System.out.println("Valor atual: " + tipoServico.getValor());
        System.out.println("Novo Valor (ENTER para manter):");
        String valor = s.nextLine();
        if (!valor.isEmpty()){
            tipoServico.setValor(Double.parseDouble(valor));
        }
        System.out.println("Status atual: " + tipoServico.getStatus());
        System.out.println("Novo Status (Agendado / Em andamento / Concluído):");
        String status = s.nextLine();
        if (!status.isEmpty()){
            tipoServico.setStatus(status);
        }
        System.out.println("=== Serviço atualizado com sucesso! ===");

    }

    void removerServico(){
        System.out.println("Informe o ID do serviço: ");
        int servicoID = Integer.parseInt(s.nextLine());
        Servico servico = servicoService.buscarPorId(servicoID);

        if (servico == null){
            System.out.println("Serviço não encontrado.");
            System.out.println("=== Retornando ao menu... ===");
            return;
        }

        System.out.println("Serviço encontrado:");
        System.out.println("Tipo: " + servico.getNomeServico());
        System.out.println("Data: " + servico.getData());
        System.out.println("Cliente ID: " + servico.getClienteID());
        System.out.println("Tem certeza que deseja remover? (S/N): ");
        String confirmacao = s.nextLine();

        if (confirmacao.equalsIgnoreCase("S")){
            servicoService.excluir(servicoID);
            System.out.println("=== Serviço removido com sucesso! ===");
        }else{
            System.out.println("Operação cancelada.");
        }

    }
    public void menuServicos() {
        int opcao = 10;
        do {
            menuServicoPrincipal();
            opcao = Integer.parseInt(s.nextLine());
            switch (opcao) {
                case 1:
                    cadastrarServico();
                    break;
                case 2:
                    servicoService.listar();
                    break;
                case 3:
                    atualizarServico();
                    break;
                case 4:
                    removerServico();
                    break;
                default:
                    System.out.println("Encerrando o sistema!");
                    break;
            }
        } while (opcao != 0);
    }
}
