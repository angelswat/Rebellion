/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebellion;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Usuario
 */
public class Universo {
    private static int numFil;
    private static int numCol;
    private static int agentes;
    private static int policias;
    private static ArrayList<Posicion> tablero=new ArrayList<>();
    private static ArrayList<Agente> agenttes=new ArrayList<>();
    private static ArrayList<Policia> cops=new ArrayList<>();
    
    public Universo(int numFil, int numCol, int agentes, int policias){
        this.numFil=numFil;
        this.numCol=numCol;
        this.agentes=agentes;
        this.policias=policias;
    }

    public static void colocarPolicias(){
        int posFila;
        int posCol;
        boolean existe=false;
        int i=0;
        Random r=new Random();
        do{
            posFila=r.nextInt(numFil-1);
            posCol=r.nextInt(numCol-1);
            for (Posicion par:tablero){
                if (par.getPosx()==posFila && par.getPosy()==posCol){
                    existe=true;
                    break;
                }
            }
        }
        while(existe==true);
        Posicion coord=new Posicion(posFila,posCol);
        tablero.add(coord);
        Policia a=new Policia(coord);
        cops.add(a);
    }
    
    public static void colocarAgentes(){
        int posFila;
        int posCol;
        boolean existe=false;
        Random r=new Random();
        do{
            posFila=r.nextInt(numFil-1);
            posCol=r.nextInt(numCol-1);
            for (Posicion par:tablero){
                if (par.getPosx()==posFila && par.getPosy()==posCol){
                    existe=true;
                    break;
                }
            }
        }
        while(existe==true);
        Posicion coord=new Posicion(posFila,posCol);
        tablero.add(coord);
        Agente a=new Agente(1,coord);
        agenttes.add(a);

    }
   /*
    public int indentificarRebeldes(Agente agente){
        for (Agente par:coordenadas){
            //if (par instanceof Agente){
                
            //}
        }
        return 1;
    }
    */
    public boolean encarcelar(Agente agente){
        if(agente.getEstado()==1){
            return true;
        }
        return false;
    }
    
    public void imprimirUniverso(){
        //for (int i=0;i<this.numFil;i++){
          //  for (int j=0;j<this.numCol;j++){
                for (Posicion coord:tablero){
                    System.out.println(coord);
                }
            //}
       // }
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
