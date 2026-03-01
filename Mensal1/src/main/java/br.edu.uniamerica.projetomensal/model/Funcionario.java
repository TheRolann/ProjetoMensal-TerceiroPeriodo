package br.edu.uniamerica.projetomensal.model;

import br.edu.uniamerica.projetomensal.model.enums.Cargo;
import br.edu.uniamerica.projetomensal.model.enums.Status;

public class Funcionario {
    // Atributos
    private int id;
    private String nome;
    private String cpf;
    private Cargo cargo;
    private Status status;

     // Construtor
    public Funcionario(int id, String nome, String cpf, Cargo cargo, Status status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.status = status;
    }

    // Getters e Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
