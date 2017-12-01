/*
 * Rebellion Agent Model. Noviembre, 2017.
 * Copyright (c) 2017 Angel Encalada.
 * Escuela Superior Politecnica del Litoral
 * Todos los derechos reservados.
 */

package rebellion;

/**
 * @author Angel Encalada
 * @param Heredar algunos atributos comunes en los hijos.
 */

//Inicio de la clase
public abstract class Persona {
    //Numero de filas del universo.
    int numFil=Rebellion.numFil;
    //Numero de columnas del universo.
    int numCol=Rebellion.numCol;
    //Radio de vision de los agentes y policias en el universo.
    int radio=Rebellion.radio;
}
//Fin de la clase.