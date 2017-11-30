/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebellion;
import java.util.ArrayList;
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
    
    @Override
    public void crearPosAleat(){
        int posx=(int) Math.floor(Math.random() * super.numFil);
        int posy=(int) Math.floor(Math.random() * super.numCol);
        this.posPolicia=new Posicion(posx,posy);
    }
    
    private void llenarRango(){
        
    }
}
