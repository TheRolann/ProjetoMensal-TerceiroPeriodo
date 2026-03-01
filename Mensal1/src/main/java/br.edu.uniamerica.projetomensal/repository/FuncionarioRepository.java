package br.edu.uniamerica.projetomensal.repository;

import br.edu.uniamerica.projetomensal.model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {
    // Crianco o "banco de dados" em memoria

    // Criando a List do tipo Cliente
    private List<Funcionario> funcionarios  = new ArrayList<>();

    public void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void excluir(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public List<Funcionario> listar() {
        return funcionarios;
    }

    public Funcionario buscarPorId(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }
}
