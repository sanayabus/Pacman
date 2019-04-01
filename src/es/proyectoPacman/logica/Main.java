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

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Mapa mapa = new Mapa();
        
        for(int i=0; i<=10; i++){
        mapa.movimiento(3);
        mapa.mostrarTablero();
        }
        for(int i=0; i<=4; i++){
        mapa.movimiento(0);
        mapa.mostrarTablero();
        }
        for(int i=0; i<=2; i++){
        mapa.movimiento(2);
        mapa.mostrarTablero();
        }
    }
    
}
