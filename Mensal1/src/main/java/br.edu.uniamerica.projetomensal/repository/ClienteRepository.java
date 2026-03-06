package br.edu.uniamerica.projetomensal.repository;

import br.edu.uniamerica.projetomensal.model.Cliente;
import br.edu.uniamerica.projetomensal.interfaces.Crud;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements Crud<Cliente>{
    // Crianco o "banco de dados" em memoria

    // Criando a List do tipo Cliente
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void excluir(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public void editar(Cliente cliente) {}

    @Override
    public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> listar() {
        return clientes;
    }
}
