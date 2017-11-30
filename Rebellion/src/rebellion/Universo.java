/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebellion;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Usuario
 */
public class Universo{
    private static int numFil=Rebellion.numFil;
    private static int numCol=Rebellion.numCol;
    private static double agentes=Math.round(Rebellion.denAg*100);
    private static double policias=Math.round(Rebellion.denPol*100);
    private static ArrayList<Posicion> tablero=new ArrayList<>();
    private static ArrayList<Agente> agenttes=new ArrayList<>();
    private static ArrayList<Policia> cops=new ArrayList<>();
    private static ArrayList<Posicion> vacios=new ArrayList<>();
    
    /*
    public Universo(int numFil, int numCol, int agentes, int policias){
        this.numFil=numFil;
        this.numCol=numCol;
        //this.agentes=agentes;
        //this.policias=policias;
    }
    */
    
    public static void colocarPolicias(){
        System.out.println("Colocar policias");
        int posFila;
        int posCol;
        boolean existe=false;
        Random r=new Random();
        do{
            
            posFila=r.nextInt(numFil);
            posCol=r.nextInt(numCol);
            for (Posicion par:tablero){
                if (par.getPosx()==posFila && par.getPosy()==posCol){
                    System.out.println(par);
                    existe=true;
                    break;
                }
            }
        }
        while(existe==true);
        Posicion coord=new Posicion(posFila,posCol);
        System.out.println(coord);
        tablero.add(coord);
        Policia a=new Policia(coord);
        cops.add(a);
    }
    
    public static void colocarAgentes(){
        System.out.println("Colocar agentes");
        int posFila;
        int posCol;
        boolean existe=false;
        Random r=new Random();
        do{
            
            posFila=r.nextInt(numFil);
            posCol=r.nextInt(numCol);
            for (Posicion par:tablero){
                if (par.getPosx()==posFila && par.getPosy()==posCol){
                    System.out.println(par);
                    existe=true;
                    break;
                }
            }
        }while(existe==true);
        Posicion coord=new Posicion(posFila,posCol);
        System.out.println(coord);
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
    
    public static boolean encarcelar(Agente agente){
        if(agente.getEstado()==1){
            return true;
        }
        return false;
    }
    
    public static void imprimirUniverso(){
        //Collections.sort(tablero);
        String cadena="";
        for (int i=0;i<numFil;i++){
            for (int j=0;j<numCol;j++){
                Posicion p=new Posicion(i,j);
                String obj=" ";
                
                if(!agenttes.contains(p)&&!cops.contains(p)){
                    obj="O";
                }
                if (cops.contains(p)){
                    obj="P";
                }
                for (Agente ag:agenttes){
                    if (ag.getPosAgente().equals(p)){
                        if(ag.getEstado()==1){
                            obj="A";
                        }
                        if (ag.getEstado()==0){
                            obj="I";
                        }
                        if (ag.getEstado()==2){
                            obj="E";
                        }
                    }
                }
                cadena+=obj;
                cadena+=" ";
            }
            System.out.println(cadena+"\n");
            cadena="";
        }
        
    }
    
    public static boolean identificarAgVision(){
        //testear rebeldes por rango de vision
        return true;
    }

    public static int contarEncarcelados(){
        int encarcelados=0;
        for (Agente ag:agenttes){
            if (ag.getEstado()==2){
                encarcelados++;
            }
        }
        return encarcelados;
    }
    
    public static int contarActivos(){
        int activos=0;
        for (Agente ag:agenttes){
            if (ag.getEstado()==1){
                activos++;
            }
        }
        return activos;
    }
    
    public static int contarInactivos(){
        int inactivos=0;
        for (Agente ag:agenttes){
            if (ag.getEstado()==0){
                inactivos++;
            }
        }
        return inactivos;
    }
    
    public static void encerarTablero(){
        agenttes.clear();
        cops.clear();
        tablero.clear();
    }
    
    public static void generarCsv(int Turno){
        int numEnc=Universo.contarEncarcelados();
        int numPas=Universo.contarInactivos();
        int numAct=Universo.contarActivos();
        String nomArchivo="Archivo"+Turno+".csv";
        String delimitador=",";
        try {  
        FileWriter fw=new FileWriter(nomArchivo);
        fw.append(Integer.toString(Turno)).append(delimitador);
        fw.append(Integer.toString(numPas)).append(delimitador);
        fw.append(Integer.toString(numAct)).append(delimitador);
        fw.append(Integer.toString(numEnc));
        }catch(IOException e){
            e.printStackTrace();
        }
        
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

    public double getAgentes() {
        return agentes;
    }

    public void setAgentes(double agentes) {
        this.agentes = agentes;
    }

    public double getPolicias() {
        return policias;
    }

    public void setPolicias(double policias) {
        this.policias = policias;
    }
}
