package br.edu.uniamerica.projetomensal.service;

import br.edu.uniamerica.projetomensal.interfaces.Crud;
import br.edu.uniamerica.projetomensal.model.Funcionario;
import br.edu.uniamerica.projetomensal.model.enums.Cargo;
import br.edu.uniamerica.projetomensal.model.enums.Status;
import br.edu.uniamerica.projetomensal.repository.FuncionarioRepository;

import java.util.List;

// Classe de servico para gerenciar as operacoes relacionadas aos clientes
// Esta classe implementa a interface Crud para fornecer as operacoes basicas de cadastro, exclusao, edicao e consulta de clientes

public class FuncionarioService implements Crud<Funcionario> {

    // Instancia do repository para acessar os dados dos clientes
    private FuncionarioRepository repository = new FuncionarioRepository();
    private int proximoId = 1;

    // Construtor padrao que ja inicializa o repository com ID predefinido, ordem crescente
    public Funcionario cadastrarFuncionario(String nome, String cpf, String telefone, String email, double salario, Cargo cargo, Status status) {
        Funcionario funcionario = new Funcionario(proximoId++, nome, cpf, telefone, email, salario, cargo, status);
        salvar(funcionario);

        return funcionario;
    }

    // Metodos da interface Crud implementados para realizar as operacoes de salvar, excluir, editar, buscar por ID e listar clientes

    @Override
    public void salvar(Funcionario funcionario) {
        repository.salvar(funcionario);
    }

    @Override
    public void excluir(int id) {
        repository.excluir(id);
    }

    // Metodo de edicao que busca o cliente existente por ID e atualiza seus dados com os novos valores fornecidos
    @Override
    public void editar(Funcionario funcionario) {
        Funcionario funcionarioExistente = buscarPorId(funcionario.getId());

        if (funcionarioExistente != null) {
            funcionarioExistente.setNome(funcionario.getNome());
            funcionarioExistente.setCpf(funcionario.getCpf());
            funcionarioExistente.setTelefone(funcionario.getTelefone());
            funcionarioExistente.setEmail(funcionario.getEmail());
            funcionarioExistente.setSalario(funcionario.getSalario());
            funcionarioExistente.setCargo(funcionario.getCargo());
            funcionarioExistente.setStatus(funcionario.getStatus());
        }
    }

    @Override
    public Funcionario buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // Metodo para listar todos os clientes cadastrados, retornando uma lista de objetos Cliente
    @Override
    public List<Funcionario> listar() {
        return repository.listar();
    }
}
