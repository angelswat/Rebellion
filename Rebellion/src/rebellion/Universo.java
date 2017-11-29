/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebellion;
import java.util.Random;
/**
 *
 * @author Usuario
 */
public class Universo {
    private int numFil;
    private int numCol;
    private int agentes;
    private int policias;
    
    public Universo(){
        numFil=10;
        numCol=10;
    }
    
    public Universo(int numFil, int numCol, int agentes, int policias){
        this.numFil=numFil;
        this.numCol=numCol;
        this.agentes=agentes;
        this.policias=policias;
    }

    public void colocarPolicias(){
        //para colocar policias random
    }
    
    public int indentificarRebeldes(){
        //para identificar rebeldes
        return 1;
    }
    
    public void encarcelar(){
        //para encarcelar activos segun las variables
    }
    
    public void imprimirUniverso(){
        //imprimir como va cambiando
    }
    
    public boolean identificarAgVision(){
        //testear rebeldes por rango de vision
        return true;
    }
    
    public int contarEncarcelados(){
        //contabilizar presos para aniadir al csv
        return 1;
    }
    
    
    
    
    
    
    
    
    public int getNumFil() {
        return numFil;
    }

    public void setNumFil(int numFil) {
        this.numFil = numFil;
    }

    public int getNumCol() {
        return numCol;
    }

    public void setNumCol(int numCol) {
        this.numCol = numCol;
    }

    public int getAgentes() {
        return agentes;
    }

    public void setAgentes(int agentes) {
        this.agentes = agentes;
    }

    public int getPolicias() {
        return policias;
    }

    public void setPolicias(int policias) {
        this.policias = policias;
    }
    
    
}
