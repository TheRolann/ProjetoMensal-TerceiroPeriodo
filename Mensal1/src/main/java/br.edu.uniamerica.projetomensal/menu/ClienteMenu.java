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
            System.out.println("________________________________________");
            System.out.println("| === === SISTEMA DETETIZADORA === === |");
            System.out.println("|  -- --- --- Menu Cliente --- --- --  |");
            System.out.println("| 1 - Cadastar                         |");
            System.out.println("| 2 - Editar                           |");
            System.out.println("| 3 - Apagar                           |");
            System.out.println("| 4 - Listar                           |");
            System.out.println("| 0 - Voltar                           |");
            System.out.println("----------------------------------------");
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
        System.out.println("|--------------------------------------|");
        System.out.println("|  --- --- Cadastro de Cliente --- --- |");
        System.out.println("|--------------------------------------|");
        System.out.println("| Nome da Empresa: ");
        String nomeEmpresa = sc.nextLine();
        System.out.println("| CNPJ: ");
        String cnpj = sc.nextLine();
        System.out.println("| CPF: ");
        String cpf = sc.nextLine();
        System.out.println("| Endereço: ");
        String endereco = sc.nextLine();
        System.out.println("| Telefone: ");
        String telefone = sc.nextLine();
        System.out.println("| Email: ");
        String email = sc.nextLine();
        System.out.println("| Status (ATIVO/INATIVO): ");
        String statusInput = sc.nextLine();
        Status status = Status.valueOf(statusInput.toUpperCase());

        clienteService.cadastrarCliente(nomeEmpresa, cnpj, cpf, endereco, telefone, email, status);
        System.out.println("| Cliente cadastrado com sucesso!       |");
        System.out.println("|---------------------------------------|");
    }

    void listarCliente() {
        List<Cliente> clientes = clienteService.listar();

        System.out.println("|--------------------------------------|");
        System.out.println("|  --- --- Lista de Clientes --- ---   |");
        System.out.println("|--------------------------------------|");

        for (Cliente c : clientes) {
            System.out.println("|--------------------------------------|");
            System.out.println("| ID: " + c.getId() + "\t |");
            System.out.println("| Nome da Empresa: " + c.getNomeEmpresa() + "\t |");
            System.out.println("| CNPJ: " + c.getCnpj() + "\t |");
            System.out.println("| CPF: " + c.getCpf() + "\t |");
            System.out.println("| Endereço: " + c.getEndereco() + "\t |");
            System.out.println("| Telefone: " + c.getTelefone() + "\t |");
            System.out.println("| Email: " + c.getEmail() + "\t |");
            System.out.println("| Status: " + c.getStatus() + "\t |");
            System.out.println("|--------------------------------------|");
        }
    }

    void excluirCliente() {
        System.out.println("|--------------------------------------|");
        System.out.println("|    --- --- Excluir Cliente --- ---   |");
        System.out.println("|--------------------------------------|");
        System.out.println("| Informe o ID do cliente: ");
        int id = Integer.parseInt(sc.nextLine());
        clienteService.excluir(id);
        System.out.println("| Cliente excluído com sucesso!         |");
        System.out.println("|---------------------------------------|");
    }

    void editarCliente() {
        System.out.println("|--------------------------------------|");
        System.out.println("|    --- --- Editar Cliente --- ---    |");
        System.out.println("|--------------------------------------|");
        System.out.println("| Informe o ID do cliente: ");
        int id = Integer.parseInt(sc.nextLine());
        Cliente cliente = clienteService.buscarPorId(id);

        if(cliente == null) {
            System.out.println("| ERRO! Cliente não encontrado.        |");
            System.out.println("|--------------------------------------|");
            return;
        }

        System.out.println("| Cliente encontrado!                   |");
        System.out.println("| Nome da empresa atual: " + cliente.getNomeEmpresa());
        System.out.println("| Novo nome da empresa (ENTER para manter): ");
        String nomeEmpresa = sc.nextLine();
        if (!nomeEmpresa.isEmpty()) {
            cliente.setNomeEmpresa(nomeEmpresa);
        }
        System.out.println("| Telefone atual: " + cliente.getTelefone());
        System.out.println("| Novo telefone (ENTER para manter): ");
        String telefone = sc.nextLine();
        if (!telefone.isEmpty()) {
            cliente.setTelefone(telefone);
        }
        System.out.println("| Email atual: " + cliente.getEmail());
        System.out.println("| Novo e-mail (ENTER para manter): ");
        String email = sc.nextLine();
        if (!email.isEmpty()) {
            cliente.setEmail(email);
        }
        System.out.println("| Status atual: " + cliente.getStatus());
        System.out.println("| Novo status (ATIVO/INATIVO) (ENTER para manter): ");
        String statusInput = sc.nextLine();
        if (!statusInput.isEmpty()) {
            Status status = Status.valueOf(statusInput.toUpperCase());
            cliente.setStatus(status);
        }
        clienteService.editar(cliente);
        System.out.println("| Cliente atualizado com sucesso!       |");
        System.out.println("|---------------------------------------|");
    }
}
