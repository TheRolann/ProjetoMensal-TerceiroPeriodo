package br.edu.uniamerica.projetomensal.repository;

import br.edu.uniamerica.projetomensal.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    // Crianco o "banco de dados" em memoria

    // Criando a List do tipo Cliente
    private List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    public void excluir(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
