package br.edu.uniamerica.projetomensal.service;

import br.edu.uniamerica.projetomensal.interfaces.Crud;
import br.edu.uniamerica.projetomensal.model.Cliente;
import br.edu.uniamerica.projetomensal.repository.ClienteRepository;

public class ClienteServico implements Crud<Cliente> {

    private ClienteRepository repository = new ClienteRepository();

    @Override
    public void salvar(Cliente cliente) {
        repository.salvar(cliente);
    }

    @Override
    public void excluir(int id) {
        Cliente cliente = buscarPorId(id);
        if (cliente != null) {
            repository.excluir(cliente);
        }
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente clienteExistente = buscarPorId(cliente.getId());
        if (clienteExistente != null) {
            clienteExistente.setNomeEmpresa(cliente.getNomeEmpresa());
            clienteExistente.setCnpj(cliente.getCnpj());
            clienteExistente.setCpf(cliente.getCpf());
            clienteExistente.setStatus(cliente.getStatus());
        }
    }

    @Override
    public Cliente buscarPorId(int id) {
        return repository.buscarPorId(id);
    }
}
