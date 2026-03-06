package br.edu.uniamerica.projetomensal.interfaces;

import java.util.List;

// Interface do tipo generico, nao sabe qual objeto manipular, "T" placeholder
// Possibilitado criar apenas uma interface
public interface Crud<T> {
    void salvar(T objeto);
    void excluir(T objeto);
    void editar(T objeto);
    T buscarPorId(int id);
    List<T> listar();
}
