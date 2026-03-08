package br.edu.uniamerica.projetomensal.relatorio;

import br.edu.uniamerica.projetomensal.service.ClienteService;

public class RelatorioCliente {

    public void totalClientes() {
        ClienteService clienteService = new ClienteService();
        int total = clienteService.listar().size();

        System.out.println("|--------------------------------------|");
        System.out.println("|  --- --- Relatorio Clientes --- ---  |");
        System.out.println("| Total de Clientes: " + total + "         |");
        System.out.println("|--------------------------------------|");
    }
}
