package br.edu.uniamerica.projetomensal.repository;

import java.util.ArrayList;
import java.util.List;
import br.edu.uniamerica.projetomensal.interfaces.Crud;
import br.edu.uniamerica.projetomensal.model.Servico;

public class ServicoRepository implements Crud<Servico>{
    private List<Servico> lista = new ArrayList<>();

    @Override
    public void salvar(Servico servico) {
        lista.add(servico);
    }

    @Override
    public void excluir(Servico servico) {
        lista.remove(servico);
    }

    @Override
    public void editar(Servico servico) {}

    @Override
    public Servico buscarPorId(int id) {
        for(Servico servico : lista) {
            if (servico.getId() == id) {
                return servico;
            }
        }
        return null;
    }

    public List<Servico> listar() {
        return lista;
    }
}
