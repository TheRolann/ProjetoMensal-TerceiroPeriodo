package br.edu.uniamerica.projetomensal.service;

import br.edu.uniamerica.projetomensal.model.Servico;
import br.edu.uniamerica.projetomensal.repository.ServicoRepository;
import br.edu.uniamerica.projetomensal.model.enums.Status;
import br.edu.uniamerica.projetomensal.interfaces.Crud;

import java.util.List;

public class ServicoService implements Crud<Servico> {

    private ServicoRepository repository = new ServicoRepository();
    private int proximoId = 1;

    public void cadastrar(String nomeServico, String descricao, String data, double valor, int clienteID, Status status) {
        Servico servico = new Servico(proximoId++, nomeServico, descricao, data, valor, clienteID, status);

        salvar(servico);
    }

    @Override
    public void salvar(Servico servico) {
        repository.salvar(servico);
    }

    @Override
    public void excluir(int id) {
       repository.excluir(id);
    }

    @Override
    public void editar(Servico servico) {
        Servico servicoExistente = buscarPorId(proximoId);

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


   @Override
   public Servico buscarPorId(int id) {
       return repository.buscarPorId(id);
   }
}