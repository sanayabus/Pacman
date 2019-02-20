/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.proyectoPacman.logica;

/**
 *
 * @author Santi
 */
public class Main {

    Mapa mapa = new Mapa();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        for(int fila=0; fila<mapa.length; fila++) {
            for(int columna=0; columna<15; columna++) {
                System.out.print(mapa[fila][columna]+" ");
            }
            System.out.println();
        }
    }
    
}
