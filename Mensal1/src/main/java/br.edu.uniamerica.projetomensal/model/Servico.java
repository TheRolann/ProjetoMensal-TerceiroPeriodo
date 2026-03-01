package br.edu.uniamerica.projetomensal.model;

public class Servico {

    private int id;
    private String nomeServico = "";
    private String descricao = "";
    private String data = "";
    private double valor;
    private int clienteID;
    private String status;

    public Servico(int id, String nomeServico, String descricao, String data,
                   double valor, int clienteID, String status){
        this.id = id;
        this.nomeServico = nomeServico;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.clienteID = clienteID;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
