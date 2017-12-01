/*
 * Rebellion Agent Model. Noviembre, 2017.
 * Copyright (c) 2017 Angel Encalada.
 * Escuela Superior Politecnica del Litoral
 * Todos los derechos reservados.
 */

package rebellion;

/**
 * @author Angel Encalada
 * @param Contruir una coordenada de referencia para el universo.
 */

//Inicio de la clase.
public class Posicion {
    //Coordenada de referencia en el eje x, o fila.
    private int posx;
    //Coordenada de referencia en el eje y, o columna.
    private int posy;
    
    //Constructor de la clase.
    public Posicion(int posx, int posy){
        this.posx=posx;
        this.posy=posy;
    }

    /**
    * Metodos getter y setter del constructor de la clase.
    */
    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    /**
    * Metodo sobreescrito de la clase ToString, util para la impresion del universo.
    */
    @Override
    public String toString() {
        return "(" + posx + "," + posy + ")";
    }
}
//Fin de la clase.
