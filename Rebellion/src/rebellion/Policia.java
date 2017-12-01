/*
 * Rebellion Agent Model. Noviembre, 2017.
 * Copyright (c) 2017 Angel Encalada.
 * Escuela Superior Politecnica del Litoral
 * Todos los derechos reservados.
 */

package rebellion;

/**
 * @author Angel Encalada
 * @param 
 */

//Inicio de la clase
public class Policia extends Persona {
    //Posicion de un policia dentro del universo.
    private Posicion posPolicia;
    
    //Constructor 1 de la clase.
    public Policia(int numFil, int numCol, int rango){
        super();
        this.numCol=numCol;
        this.numFil=numFil;
    }
    
    //Constructor 2 de la clase.
    public Policia(Posicion posPolicia){
        this.posPolicia=posPolicia;
    }
}
//Fin de la clase.
