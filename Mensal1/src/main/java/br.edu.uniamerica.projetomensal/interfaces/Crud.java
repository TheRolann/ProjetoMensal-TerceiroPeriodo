package br.edu.uniamerica.projetomensal.interfaces;

public interface Crud<T> {
    void salvar(T objeto);
    void excluir(int id);
    void editar(T objeto);
    T buscarPorId(int id);
}
