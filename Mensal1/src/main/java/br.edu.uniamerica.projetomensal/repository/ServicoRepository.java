package br.edu.uniamerica.projetomensal.repository;

import java.util.ArrayList;
import java.util.List;
import br.edu.uniamerica.projetomensal.interfaces.Crud;
import br.edu.uniamerica.projetomensal.model.Servico;

// Classe repository, que implementa a interface Crud, e é responsável por realizar as operações de CRUD (Create, Read, Update, Delete) para a entidade Servico
public class ServicoRepository implements Crud<Servico>{
    // Crianco o "banco de dados" em memoria
    // Criando a List do tipo Servico
    private static List<Servico> servicos = new ArrayList<>();

    // Sobreescrita dos metodos da interface Crud, para realizar as operacoes

    @Override
    public void salvar(Servico servico) {
        servicos.add(servico);
    }

    // Apaga o servico da lista, caso o id seja encontrado, pelo numero do id, utilizando o metodo buscarPorId para encontrar
    @Override
    public void excluir(int id) {
        Servico servico = buscarPorId(id);
        if (servico != null) {
            servicos.remove(servico);
        }
    }

    // Editar vazio, pois a edicao do servico pode ser feita diretamente na lista, utilizando o metodo buscarPorId para encontrar o servico e editar seus atributos
    @Override
    public void editar(Servico servico) {}

    // Busca o servico na lista por id com for each, caso nao tenha, retorna null
    @Override
    public Servico buscarPorId(int id) {
        for(Servico servico : servicos) {
            if (servico.getId() == id) {
                return servico;
            }
        }
        return null;
    }

    // Lista todos os servicos da lista, utilizando o metodo listar para retornar a lista de servicos
    public List<Servico> listar() {
        return servicos;
    }
}
