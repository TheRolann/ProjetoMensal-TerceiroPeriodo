package br.edu.uniamerica.projetomensal.menu;

import br.edu.uniamerica.projetomensal.model.Cliente;
import br.edu.uniamerica.projetomensal.model.enums.Status;
import br.edu.uniamerica.projetomensal.service.ClienteService;

import java.util.List;
import java.util.Scanner;

public class ClienteMenu {

    private ClienteService clienteService = new ClienteService();
    Scanner sc = new Scanner(System.in);

    int opcao;

    public void iniciar() {
        do {
            System.out.println("\n|--------------------------------------|");
            System.out.println("| === === SISTEMA DETETIZADORA === === |");
            System.out.println("|  -- --- --- Menu Cliente --- --- --  |");
            System.out.println("| 1 - Cadastar                         |");
            System.out.println("| 2 - Editar                           |");
            System.out.println("| 3 - Apagar                           |");
            System.out.println("| 4 - Listar                           |");
            System.out.println("| 0 - Voltar                           |");
            System.out.println("|--------------------------------------|");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    editarCliente();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    listarCliente();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    void cadastrarCliente() {
        System.out.println("\n|--------------------------------------|");
        System.out.println("|  --- --- Cadastro de Cliente --- --- |");
        System.out.println("|--------------------------------------|");
        System.out.print("| Nome da Empresa: ");
        String nomeEmpresa = sc.nextLine();
        System.out.print("| Documento (CPF/CNPJ): ");
        String documento = sc.nextLine();
        System.out.print("| Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("| Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("| Email: ");
        String email = sc.nextLine();
        System.out.print("| Status\n| 1 - ATIVO\n| 2 - INATIVO\n| Informe o numero do status: ");
        int statusInput = Integer.parseInt(sc.nextLine());
        Status status = Status.values()[statusInput - 1];

        Cliente cliente = clienteService.cadastrarCliente(nomeEmpresa, documento, endereco, telefone, email, status);
        System.out.println("|---------------------------------------|");
        System.out.println("| Cliente cadastrado com sucesso!       |");
        System.out.println("| ID do Cliente: " + cliente.getId() + "\t\t\t\t|");
        System.out.println("|---------------------------------------|");
    }

    void listarCliente() {
        List<Cliente> clientes = clienteService.listar();

        System.out.println("\n|--------------------------------------|");
        System.out.println("|  --- --- Lista de Clientes --- ---   |");
        System.out.println("|--------------------------------------|");

        for (Cliente c : clientes) {
            System.out.println("\n|--------------------------------------|");
            System.out.println("| ID: " + c.getId() + "\t |");
            System.out.println("| Nome da Empresa: " + c.getNomeEmpresa() + "\t |");
            System.out.println("| Documento: " + c.getDocumento() + "\t |");
            System.out.println("| Endereço: " + c.getEndereco() + "\t |");
            System.out.println("| Telefone: " + c.getTelefone() + "\t |");
            System.out.println("| Email: " + c.getEmail() + "\t |");
            System.out.println("| Status: " + c.getStatus() + "\t |");
            System.out.println("|--------------------------------------|");
        }
    }

    void excluirCliente() {
        System.out.println("\n|--------------------------------------|");
        System.out.println("|    --- --- Excluir Cliente --- ---   |");
        System.out.println("|--------------------------------------|");
        System.out.println("| Informe o ID do cliente: ");
        int id = Integer.parseInt(sc.nextLine());
        clienteService.excluir(id);
        System.out.println("| Cliente excluído com sucesso!         |");
        System.out.println("|---------------------------------------|");
    }

    void editarCliente() {
        System.out.println("\n|--------------------------------------|");
        System.out.println("|    --- --- Editar Cliente --- ---    |");
        System.out.println("|--------------------------------------|");
        System.out.println("| Informe o ID do cliente: ");
        int id = Integer.parseInt(sc.nextLine());
        Cliente cliente = clienteService.buscarPorId(id);

        if(cliente == null) {
            System.out.println("|--------------------------------------|");
            System.out.println("| ERRO! Cliente não encontrado.        |");
            System.out.println("|--------------------------------------|");
            return;
        }

        System.out.println("|--------------------------------------|");
        System.out.println("| Cliente encontrado!                  |");
        System.out.println("| Nome da empresa atual: " + cliente.getNomeEmpresa());
        System.out.print("| Novo nome da empresa (ENTER para manter): ");
        String nomeEmpresa = sc.nextLine();
        if (!nomeEmpresa.isEmpty()) {
            cliente.setNomeEmpresa(nomeEmpresa);
        }
        System.out.println("| Telefone atual: " + cliente.getTelefone());
        System.out.print("| Novo telefone (ENTER para manter): ");
        String telefone = sc.nextLine();
        if (!telefone.isEmpty()) {
            cliente.setTelefone(telefone);
        }
        System.out.println("| Email atual: " + cliente.getEmail());
        System.out.print("| Novo e-mail (ENTER para manter): ");
        String email = sc.nextLine();
        if (!email.isEmpty()) {
            cliente.setEmail(email);
        }
        System.out.println("| Status atual: " + cliente.getStatus());
        System.out.print("| Novo status\n| 1 - ATIVO\n| 2 - INATIVO)\n| Informe o numero do status (ENTER para manter): ");
        int statusInput = Integer.parseInt(sc.nextLine());
        if (statusInput > 0 && statusInput <= Status.values().length) {
            Status status = Status.values()[statusInput - 1];
            cliente.setStatus(status);
        } else if (statusInput != 0) {
            System.out.println("| Status inválido. Mantendo status atual. |");
        }
        clienteService.editar(cliente);
        System.out.println("|---------------------------------------|");
        System.out.println("| Cliente atualizado com sucesso!       |");
        System.out.println("|---------------------------------------|");
    }
}
