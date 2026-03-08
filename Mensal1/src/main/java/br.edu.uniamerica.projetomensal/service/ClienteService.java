package br.edu.uniamerica.projetomensal.service;

import br.edu.uniamerica.projetomensal.interfaces.Crud;
import br.edu.uniamerica.projetomensal.model.Cliente;
import br.edu.uniamerica.projetomensal.model.enums.Status;
import br.edu.uniamerica.projetomensal.repository.ClienteRepository;

import java.util.List;

public class ClienteService implements Crud<Cliente> {

    private ClienteRepository repository = new ClienteRepository();
    private int proximoId = 1;

    public void cadastrarCliente(String nomeEmpresa, String cnpj, String cpf, String endereco, String telefone, String email, Status status) {
        Cliente cliente = new Cliente(proximoId++, nomeEmpresa, cnpj, cpf, endereco, telefone, email, status);

        salvar(cliente);
    }

    @Override
    public void salvar(Cliente cliente) {
        repository.salvar(cliente);
    }

    @Override
    public void excluir(int id) {
        repository.excluir(id);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente clienteExistente = buscarPorId(cliente.getId());

        if (clienteExistente != null) {
            clienteExistente.setNomeEmpresa(cliente.getNomeEmpresa());
            clienteExistente.setCnpj(cliente.getCnpj());
            clienteExistente.setCpf(cliente.getCpf());
            clienteExistente.setEndereco(cliente.getEndereco());
            clienteExistente.setTelefone(cliente.getTelefone());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setStatus(cliente.getStatus());
        }
    }

    @Override
    public Cliente buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    @Override
    public List<Cliente> listar() {
        return repository.listar();
    }

}
