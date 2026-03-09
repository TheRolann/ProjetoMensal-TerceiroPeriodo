package br.edu.uniamerica.projetomensal.model;

import br.edu.uniamerica.projetomensal.model.enums.Cargo;
import br.edu.uniamerica.projetomensal.model.enums.Status;

public class Funcionario {
    // Atributos
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private double salario;
    private Cargo cargo;
    private Status status;

     // Construtor
    public Funcionario(int id, String nome, String cpf, String telefone, String email, double salario, Cargo cargo, Status status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.salario = salario;
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

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
