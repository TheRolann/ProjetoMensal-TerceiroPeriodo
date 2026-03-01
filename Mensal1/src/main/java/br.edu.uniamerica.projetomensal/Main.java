package br.edu.uniamerica.projetomensal;

import br.edu.uniamerica.projetomensal.menu.ServicoMenu;

public class Main {
    public void main (String[] args){
        System.out.println("Bosta de Vaca");

        ServicoMenu servicoMenu = new ServicoMenu();
        servicoMenu.menuServicos();
    }
}