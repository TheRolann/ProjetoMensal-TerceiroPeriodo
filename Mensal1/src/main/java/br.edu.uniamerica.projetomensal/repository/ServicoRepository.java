package br.edu.uniamerica.projetomensal.repository;

import java.util.ArrayList;
import java.util.List;
import br.edu.uniamerica.projetomensal.model.Servico;

public class ServicoRepository {
    private List<Servico> lista = new ArrayList<>();

    public void salvar(Servico servico) {
        lista.add(servico);
    }

    public List<Servico> listar() {
        return lista;
    }

    public void excluir(Servico servico) {
        lista.remove(servico);
    }

    public Servico buscarPorId(int id) {
        for(Servico servico : lista) {
            if (servico.getId() == id) {
                return servico;
            }
        }
        return null;
    }
}
