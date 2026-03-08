package br.edu.uniamerica.projetomensal.repository;

import br.edu.uniamerica.projetomensal.interfaces.Crud;
import br.edu.uniamerica.projetomensal.model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository implements Crud<Funcionario> {
    // Crianco o "banco de dados" em memoria

    // Criando a List do tipo Cliente
    private List<Funcionario> funcionarios  = new ArrayList<>();

    @Override
    public void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public void excluir(int id) {
    }

    @Override
    public void editar(Funcionario funcionario) {}

    @Override
    public Funcionario buscarPorId(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public List<Funcionario> listar() {
        return funcionarios;
    }
}
