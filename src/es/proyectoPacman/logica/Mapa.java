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
public class Mapa {
    
    final int ARRIBA = 0;
    final int ABAJO = 1;
    final int IZQUIERDA = 2;
    final int DERECHA = 3;
    final int PARADO = 4;
    int direccion = 0;
    int columna = 7;
    int fila = 19;
    
    // M = muro, B = punto, P = potenciador, J = jugador, V = vacío (al comer un punto)
    
    char[][] mapa = { {'M','M','M','M','M','M','M','M','M','M','M','M','M','M','M'},
                      {'M','B','B','B','B','B','B','B','B','B','B','B','B','B','M'},
                      {'M','B','M','M','M','B','M','M','M','B','M','M','M','B','M'},
                      {'M','P','M','B','B','B','B','B','B','B','B','B','M','P','M'},
                      {'M','B','M','B','M','B','M','M','M','B','M','B','M','B','M'}, 
                      {'M','B','M','B','M','B','B','B','M','B','M','B','M','B','M'}, //5
                      {'M','B','M','B','M','B','M','B','M','B','M','B','M','B','M'},
                      {'M','B','B','B','M','B','M','B','B','B','M','B','B','B','M'},
                      {'M','B','M','M','M','B','M','M','M','B','M','M','M','B','M'},
                      {'M','B','B','M','B','B','B','B','B','B','B','M','B','B','M'},
                      {'M','M','B','M','B','M','M','B','M','M','B','M','B','M','M'}, //10
                      {'B','B','B','B','B','M','B','B','B','M','B','B','B','B','B'},
                      {'M','M','B','M','M','M','M','M','M','M','M','M','B','M','M'},
                      {'M','B','B','B','B','B','B','B','B','B','B','B','B','B','M'},
                      {'M','B','M','B','M','B','M','M','M','B','M','B','M','B','M'},
                      {'M','B','M','M','M','B','B','B','B','B','M','M','M','B','M'}, //15
                      {'M','B','B','B','M','M','B','M','B','M','M','B','B','B','M'},
                      {'M','B','M','B','M','B','B','M','B','B','M','B','M','B','M'},
                      {'M','B','M','B','M','B','M','M','M','B','M','B','M','B','M'},
                      {'M','B','M','B','M','B','B','J','B','B','M','B','M','B','M'},
                      {'M','P','M','B','B','B','M','M','M','B','B','B','M','P','M'}, //20
                      {'M','B','M','M','M','B','M','B','B','B','M','M','M','B','M'},
                      {'M','B','B','B','B','B','B','B','M','B','B','B','B','B','M'},
                      {'M','M','M','M','M','M','M','M','M','M','M','M','M','M','M'},
    };
    
    public void mostrarTablero() {
        System.out.println("mostrar tablero");
        for(int fila=0; fila<mapa.length; fila++) {
            for(int columna=0; columna<15; columna++) {
                System.out.print(mapa[fila][columna]+" ");
            }
            System.out.println();
        }
    }
    public void movimiento(int direccion){
        
        switch(direccion){
            case ARRIBA:
                if(mapa[fila-1][columna] != 'M'){
                    mapa[fila][columna] = 'V';
                    mapa[fila-1][columna] = 'J';
                    fila--;
                    System.out.println("arriba");
                } else {
                    direccion = PARADO;
                    System.out.println("parado");
                }
                break;
            case ABAJO:
                if(mapa[fila+1][columna] != 'M'){
                    mapa[fila][columna] = 'V';
                    mapa[fila+1][columna] = 'J';
                    fila++;
                    System.out.println("abajo");
                } else {
                    direccion = PARADO;
                    System.out.println("parado");
                }
                break;
            case IZQUIERDA:
                if(mapa[fila][columna-1] != 'M'){
                    mapa[fila][columna] = 'V';
                    mapa[fila][columna-1] = 'J';
                    columna--;
                    System.out.println("izquierda");
                } else {
                    direccion = PARADO;
                    System.out.println("parado");
                }
                break;
            case DERECHA:
                if(mapa[fila][columna+1] != 'M'){
                    mapa[fila][columna] = 'V';
                    mapa[fila][columna+1] = 'J';
                    columna++;
                    System.out.println("derecha");
                    System.out.println(columna);
                } else {
                    direccion = PARADO;
                    System.out.println("parado");
                }
                break;
            case PARADO:
                System.out.println("PARADO");
                break;
        }
        
    }
}