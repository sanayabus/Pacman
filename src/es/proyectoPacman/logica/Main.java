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
        
        //Bucle para probar el código
        
        for(int i=0; i<=50; i++){
            mapa.mostrarTablero();
            mapa.movimiento(2);
            mapa.movimientoF();
        }
    }
    
}
