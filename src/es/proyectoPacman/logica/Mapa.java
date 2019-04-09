/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.proyectoPacman.logica;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Santi
 */
public class Mapa {
    
    final int ARRIBA = 0;
    final int ABAJO = 1;
    final int IZQUIERDA = 2;
    final int DERECHA = 3;
    int direccion = 0;
    int direccionF = 1;
    int columnaJ = 7;
    int filaJ = 19;
    int columnaF = 7;
    int filaF = 11;
    boolean gameOver = false;
    int contador = 0;
    
    Random random = new Random();
    ArrayList<Integer> direccionesFant = new ArrayList();
    int numDireccionesF = 0;
    int direccionFantAleatoria = 0;
    
    char MURO = 'M';
    char PUNTO = 'B'; // (hay un punto)
    char POTENCIADOR = 'P';
    char JUGADOR = 'J';
    char VACÍO = 'V'; // ya ha estado el jugador aquí (no hay punto)
    char FANTASMA1 = 'F';
    
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
                      {'M','M','B','M','B','M','M','V','M','M','B','M','B','M','M'}, //10
                      {'M','M','B','B','B','M','V','V','V','M','B','B','B','M','M'},
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
                      {'M','M','M','M','M','M','M','M','M','M','M','M','M','M','M'}
    };
    
    public void mostrarTablero() {
        System.out.println("mostrar tablero");
        for(int fila=0; fila<mapa.length; fila++) {
            for(int columna=0; columna<15; columna++) {
                if(columna == columnaF && fila == filaF){
                    System.out.print("F  ");
                } else {
                    System.out.print(mapa[fila][columna]+"  ");
                }
            }
            System.out.println();
        }
    }
    public void movimiento(int direccion){
        
        this.colisionFant();
        this.colisionPot();
        contador--;
        
        switch(direccion){
            case ARRIBA:
                if(mapa[filaJ-1][columnaJ] != MURO){
                    mapa[filaJ][columnaJ] = VACÍO;
                    mapa[filaJ-1][columnaJ] = JUGADOR;
                    filaJ--;
                    //System.out.println("arriba");
                } else {
                    //System.out.println("parado");
                }
                break;
            case ABAJO:
                if(mapa[filaJ+1][columnaJ] != MURO){
                    mapa[filaJ][columnaJ] = VACÍO;
                    mapa[filaJ+1][columnaJ] = JUGADOR;
                    filaJ++;
                    //System.out.println("abajo");
                } else {
                    //System.out.println("parado");
                }
                break;
            case IZQUIERDA:
                if(mapa[filaJ][columnaJ-1] != MURO){
                    mapa[filaJ][columnaJ] = VACÍO;
                    mapa[filaJ][columnaJ-1] = JUGADOR;
                    columnaJ--;
                    //System.out.println("izquierda");
                } else {
                    //System.out.println("parado");
                }
                break;
            case DERECHA:
                if(mapa[filaJ][columnaJ+1] != MURO){
                    mapa[filaJ][columnaJ] = VACÍO;
                    mapa[filaJ][columnaJ+1] = JUGADOR;
                    columnaJ++;
                    //System.out.println("derecha");
                    //System.out.println(columnaJ);
                } else {
                    //System.out.println("parado");
                }
                break;
        }
        
    }
    
    public void movimientoF(){
        
        this.direccionF();
        numDireccionesF = direccionesFant.size();
        
        if (numDireccionesF == 1){
            direccionF = direccionesFant.get(0);
        }
        else {
            numDireccionesF --;
            //direccionesFant.remove(numDireccionesF);
            direccionF = direccionesFant.get(random.nextInt(numDireccionesF));
        }
        // si el tamaño es 1 ir en la dirección que haya en la lista
        // si no
        // aleatorio de 1 menos que el tamaño
        
        switch(direccionF){
            case ARRIBA:
                if(mapa[filaF-1][columnaF] != MURO){
                    filaF--;
                    System.out.println("F arriba");
                    System.out.println(direccionesFant);
                } else {
                    System.out.println("F parado");
                    System.out.println(direccionesFant);
                }
                break;
            case ABAJO:
                if(mapa[filaF+1][columnaF] != MURO){
                    filaF++;
                    System.out.println("F abajo");
                    System.out.println(direccionesFant);
                } else {
                    System.out.println("F parado");
                    System.out.println(direccionesFant);
                }
                break;
            case IZQUIERDA:
                if(mapa[filaF][columnaF-1] != MURO){
                    columnaF--;
                    System.out.println("F izquierda");
                    System.out.println(direccionesFant);
                } else {
                    System.out.println("F parado");
                    System.out.println(direccionesFant);
                }
                break;
            case DERECHA:
                if(mapa[filaF][columnaF+1] != MURO){
                    columnaF++;
                    System.out.println("F derecha");
                    System.out.println(direccionesFant);
                } else {
                    System.out.println(direccionesFant);
                }
                break;
        }
    }
    
    public void direccionF(){
            
        direccionesFant.clear();
        
        switch(direccionF){
            case ARRIBA:
                if(mapa[filaF-1][columnaF] != MURO){
                    direccionesFant.add(ARRIBA);
                }
                if(mapa[filaF][columnaF-1] != MURO){
                    direccionesFant.add(IZQUIERDA);
                }
                if(mapa[filaF][columnaF+1] != MURO){
                    direccionesFant.add(DERECHA);
                }
                // Añadir la dirección contraria a la que lleva actuamente
                if(mapa[filaF+1][columnaF] != MURO){
                    direccionesFant.add(ABAJO);
                }
                break;
            case ABAJO:
                if(mapa[filaF+1][columnaF] != MURO){
                    direccionesFant.add(ABAJO);
                }
                if(mapa[filaF][columnaF-1] != MURO){
                    direccionesFant.add(IZQUIERDA);
                }
                if(mapa[filaF][columnaF+1] != MURO){
                    direccionesFant.add(DERECHA);
                }
                if(mapa[filaF-1][columnaF] != MURO){
                    direccionesFant.add(ARRIBA);
                }
                break;
            case IZQUIERDA:
                if(mapa[filaF][columnaF-1] != MURO){
                    direccionesFant.add(IZQUIERDA);
                }
                if(mapa[filaF-1][columnaF] != MURO){
                    direccionesFant.add(ARRIBA);
                }
                if(mapa[filaF+1][columnaF] != MURO){
                    direccionesFant.add(ABAJO);
                }
                if(mapa[filaF][columnaF+1] != MURO){
                    direccionesFant.add(DERECHA);
                }
                break;
            case DERECHA:
                if(mapa[filaF][columnaF+1] != MURO){
                    direccionesFant.add(DERECHA);
                }
                if(mapa[filaF-1][columnaF] != MURO){
                    direccionesFant.add(ARRIBA);
                }
                if(mapa[filaF+1][columnaF] != MURO){
                    direccionesFant.add(ABAJO);
                }
                if(mapa[filaF][columnaF-1] != MURO){
                    direccionesFant.add(IZQUIERDA);
                }
                break;
        }
    }
    
    public void colisionFant(){
        if (columnaJ == columnaF && filaJ == filaF){
            if (contador > 0){
                columnaF = 7;
                filaF = 11;
            } else {
                gameOver = true;
                System.out.println("GAME OVER");
            }
        }
    }
    
    public void colisionPot(){
        if (mapa[filaJ][columnaJ] == POTENCIADOR){
            contador = 25;
        }
    }
}