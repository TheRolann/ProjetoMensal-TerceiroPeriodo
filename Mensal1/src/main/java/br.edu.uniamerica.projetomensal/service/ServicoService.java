package br.edu.uniamerica.projetomensal.service;

import br.edu.uniamerica.projetomensal.model.Servico;
import br.edu.uniamerica.projetomensal.repository.ServicoRepository;
import br.edu.uniamerica.projetomensal.model.enums.Status;
import br.edu.uniamerica.projetomensal.interfaces.Crud;

import java.util.List;

// Classe de servico para gerenciar as operacoes relacionadas aos clientes
// Esta classe implementa a interface Crud para fornecer as operacoes basicas de cadastro, exclusao, edicao e consulta de clientes

public class ServicoService implements Crud<Servico> {

    // Instancia do repository para acessar os dados dos clientes
    private ServicoRepository repository = new ServicoRepository();
    private int proximoId = 1;

    // Construtor padrao que ja inicializa o repository com ID predefinido, ordem crescente
    public Servico cadastrar(String nomeServico, String descricao, String data, double valor, int clienteID, Status status) {
        Servico servico = new Servico(proximoId++, nomeServico, descricao, data, valor, clienteID, status);
        salvar(servico);

        return servico;
    }

    // Metodos da interface Crud implementados para realizar as operacoes de salvar, excluir, editar, buscar por ID e listar clientes

    @Override
    public void salvar(Servico servico) {
        repository.salvar(servico);
    }

    @Override
    public void excluir(int id) {
       repository.excluir(id);
    }

    // Metodo de edicao que busca o cliente existente por ID e atualiza seus dados com os novos valores fornecidos
    @Override
    public void editar(Servico servico) {
        Servico servicoExistente = buscarPorId(servico.getId());

        if (servicoExistente != null) {
            servicoExistente.setNomeServico(servico.getNomeServico());
            servicoExistente.setDescricao(servico.getDescricao());
            servicoExistente.setData(servico.getData());
            servicoExistente.setValor(servico.getValor());
            servicoExistente.setClienteID(servico.getClienteID());
            servicoExistente.setStatus(servico.getStatus());
        }
    }

    @Override
    public List<Servico> listar() {
       return repository.listar();
    }

    // Metodo para listar todos os clientes cadastrados, retornando uma lista de objetos Cliente
    @Override
    public Servico buscarPorId(int id) {
       return repository.buscarPorId(id);
    }
}