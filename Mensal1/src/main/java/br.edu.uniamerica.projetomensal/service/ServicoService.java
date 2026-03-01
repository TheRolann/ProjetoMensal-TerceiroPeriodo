package br.edu.uniamerica.projetomensal.service;

import br.edu.uniamerica.projetomensal.model.Servico;
import br.edu.uniamerica.projetomensal.repository.ServicoRepository;

public class ServicoService {

   private ServicoRepository repository = new ServicoRepository();
   private int proximoId = 1;

   public void cadastrar(String nomeServico, String descricao, String data, double valor, int clienteID, String status) {
       Servico servico = new Servico(proximoId, nomeServico, descricao, data, valor, clienteID, status);
       repository.salvar(servico);
   }

   public void listar() {
       if (repository.listar().isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
            System.out.println("=== Retornando ao menu... ===");
            return;
       }

       for (Servico s : repository.listar()) {
            System.out.println("ID: " + s.getId());
            System.out.println("Tipo de Serviço: " + s.getNomeServico());
            System.out.println("Descrição: " + s.getDescricao());
            System.out.println("Data Agendada: " + s.getData());
            System.out.println("Valor: " + s.getValor());
            System.out.println("Cliente ID: " + s.getClienteID());
            System.out.println("Status: " + s.getStatus());
            System.out.println("-----------------------------------");
       }
   }

   public Servico buscarPorId(int id) {
       return repository.buscarPorId(id);
   }

    public void excluir(int id) {
         Servico servico = repository.buscarPorId(id);
         if (servico != null) {
              repository.excluir(servico);
         }
    }

}