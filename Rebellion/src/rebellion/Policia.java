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
public class Policia {
    private ArrayList<Posicion> vision;
    private int numFil;
    private int numCol;
    private Posicion posPolicia;
    private int rango;
    
    public Policia(int numFil, int numCol, int rango){
        this.numCol=numCol;
        this.numFil=numFil;
    }
    
    private void crearPosAleat(){
        int posx=(int) Math.floor(Math.random() * this.numFil);
        int posy=(int) Math.floor(Math.random() * this.numCol);
    }
    
    private void llenarRango(){
        
    }
}
