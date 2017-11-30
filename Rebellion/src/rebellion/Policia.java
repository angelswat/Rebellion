/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebellion;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Angel Encalada
 */
public class Policia extends Persona {
    private Posicion posPolicia;
    private int rango;
    
    public Policia(int numFil, int numCol, int rango){
        super();
        this.numCol=numCol;
        this.numFil=numFil;
    }
    
    public Policia(Posicion posPolicia){
        this.posPolicia=posPolicia;
    }
    
    private void llenarRango(){
        
    }
}
