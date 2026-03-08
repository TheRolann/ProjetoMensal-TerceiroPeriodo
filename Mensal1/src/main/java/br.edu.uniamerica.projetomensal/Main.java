package br.edu.uniamerica.projetomensal;

import br.edu.uniamerica.projetomensal.menu.MenuPrincipal;

public class Main {
     public static void main (String[] args){
        System.out.println("Bosta de Vaca");

        MenuPrincipal servicoMenu = new MenuPrincipal();
        servicoMenu.iniciar();
    }
}