/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebellion;
import java.util.Random;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Angel Encalada
 * @param Gestionar el control de todo el universo.
 */

public class Universo{
    //Numero de filas del universo.
    private static int numFil=Rebellion.numFil;
    //Numero de columnas del universo.
    private static int numCol=Rebellion.numCol;
    //Lista de coordenadas de todas las personas.
    private static ArrayList<Posicion> tablero=new ArrayList<>();
    //Lista de coordenadas de los civiles en el universo.
    protected static ArrayList<Agente> agenttes=new ArrayList<>();
    //Lista de coordenadas de los policias del universo.
    private static ArrayList<Posicion> cops=new ArrayList<>();
    //Lista de coordenadas vacias dentro del universo.
    private static ArrayList<Posicion> vacios=new ArrayList<>();
    //Lista de coordenadas de los encarcelados en el universo.
    private static ArrayList<Posicion> encarcelados=new ArrayList<>();
    
   /**
    * Metodo que busca una coordenada vacia y situa un policia.
    */
    public static void colocarPolicias(){
        //System.out.println("Colocar policias");
        int posFila;
        int posCol;
        boolean existe=false;
        Random r=new Random();
        do{
            existe=false;
            posFila=r.nextInt(numFil);
            posCol=r.nextInt(numCol);
            for (Posicion par:tablero){
                if (par.getPosx()==posFila && par.getPosy()==posCol){
                    //System.out.println(par);
                    existe=true;
                    break;
                }
            }
        }
        while(existe==true);
        Posicion coord=new Posicion(posFila,posCol);
        //System.out.println(coord);
        tablero.add(coord);
        cops.add(coord);
    }
    
    /**
    * Metodo para buscar una coordenada vacia y colocar un agente o civil.
    */
    public static void colocarAgentes(){
        //System.out.println("Colocar agentes");
        int posFila;
        int posCol;
        boolean existe=false;
        Random r=new Random();
        do{
            existe=false;
            posFila=r.nextInt(numFil);
            posCol=r.nextInt(numCol);
            for (Posicion par:tablero){
                if (par.getPosx()==posFila && par.getPosy()==posCol){
                    //System.out.println(par);
                    existe=true;
                    break;
                }
            }
        }while(existe==true);
        Posicion coord=new Posicion(posFila,posCol);
        //System.out.println(coord);
        tablero.add(coord);
        Agente a=new Agente(0,coord,1,Math.random(),1,Math.random(),1);
        a.setEstado(a.getEstado());
        agenttes.add(a);
    }
    
    /**
    * Metodo para encarcelar civil cuando estos son activos.
    */
    public static void encarcelar(){
        for(Posicion cop:cops){
            ArrayList<Posicion> coord=calcularVision(cop);
            Random r=new Random();
            boolean existe=false;
            //System.out.println("ingreso al bucle");
            do{
                existe=false;
                if (!coord.isEmpty()){
                int pos=r.nextInt(coord.size());
                Posicion p=coord.get(pos);
                for (Agente a:agenttes){
                    if (a.getPosAgente().getPosx()==p.getPosx()&&a.getPosAgente().getPosy()==p.getPosy()){
                        if(a.getEstado()==1){
                            encarcelados.add(a.getPosAgente());
                            a.setEstado(2);
                            existe=false;
                    }
                }
            }}
        }while(existe==true);
    }
    }
    
    /**
    * Metodo para imprimir el universo representanco con letras los actores.
    */
    public static void imprimirUniverso(){
        String cadena="";
        for (int i=0;i<numFil;i++){
            for (int j=0;j<numCol;j++){
                Posicion p=new Posicion(i,j);
                String obj="";
                if (verVacios()){
                    obj="O";
                }
                for (Posicion cop:cops){
                    if(cop.getPosx()==i&&cop.getPosy()==j){
                        obj="P";
                    }
                }
                for (Agente ag:agenttes){
                    if (ag.getPosAgente().getPosx()==i&&ag.getPosAgente().getPosy()==j){
                        if(ag.getEstado()==1){
                            obj="A";
                        }
                        if (ag.getEstado()==0){
                            obj="I";
                        }}
                for(Posicion enc:encarcelados){
                        if(enc.getPosx()==ag.getPosAgente().getPosx()&&enc.getPosy()==ag.getPosAgente().getPosy()){
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
    
    /**
    * Metodo que genera las coordenadas del radio de vision de un agente o policia.
    * @return Lista de coordenadas con el alcance del radio de vision.
    */
    public static ArrayList calcularVision(Posicion h){
        ArrayList <Posicion> puntos=new ArrayList<>();
        int hor=h.getPosx()-Rebellion.radio;
        int ver=h.getPosy()-Rebellion.radio;
        if (hor>=0 && ver>=0){
            for (int i=hor;i<=2*Rebellion.radio;i++){
                for (int j=ver;j<=2*Rebellion.radio;j++){
                    if(hor+i<numFil && ver+j<numCol){
                        if (!puntos.contains(h)){
                        puntos.add(h);
                        }
                    }
                }
            }
        }
        else if(hor<0 && ver>=0){
                for(int l=0;l<=h.getPosx()+Rebellion.radio;l++){
                for (int j=ver;j<=2*Rebellion.radio;j++){
                    if(hor+l<numFil && ver+j<numCol){
                        if (!puntos.contains(h)){
                        puntos.add(h);
                        }
                    }
                }
            }
        }
        else if(hor>=0 && ver<0){
                for(int l=hor;l<=2*Rebellion.radio;l++){
                for (int j=0;j<=h.getPosy()+Rebellion.radio;j++){
                    if(hor+l<numFil && ver+j<numCol){
                        if (!puntos.contains(h)){
                        puntos.add(h);
                        }
                    }
                }
            }
        }
        return puntos;
    }
    
    /**
    * Metodo contador de civiles encarcelados en el universo.
    * @return Numero de civiles encarcelados.
    */
    public static int contarEncarcelados(){
        int encarcelados=0;
        for (Agente ag:agenttes){
            if (ag.getEstado()==2){
                encarcelados++;
            }
        }
        return encarcelados;
    }
    
    /**
    * Metodo contador de los agentes activos, previos a ser encarcelados.
    * @return Numero de agentes activos rebelandose.
    */
    public static int contarActivos(){
        int activos=0;
        for (Agente ag:agenttes){
            if (ag.getEstado()==1){
                activos++;
            }
        }
        return activos;
    }
    
    /**
    * Metodo contador de civiles inactivos o que no se han rebelado aun.
    * @return Numero de civiles pasivos, sin rebelar.
    */
    public static int contarInactivos(){
        int inactivos=0;
        for (Agente ag:agenttes){
            if (ag.getEstado()==0){
                inactivos++;
            }
        }
        return inactivos;
    }
    
    /**
    * Metodo contador de policias por rango de vision, dada una coordenada.
    * @return Numero de policias dentro de un rango de vision.
    */
    public static int contarCops(Posicion w){
        int contador=0;
        ArrayList <Posicion> lista=calcularVision(w);
        for (Posicion par:lista){
            for (Posicion cop:cops){
                if(par.getPosx()==cop.getPosx()&&par.getPosy()==cop.getPosy()){
                    contador+=1;
                }
            }
        }
        return contador;
    }
    
    /**
    * Metodo contador de los agentes que estan dentro de un radio de vision x.
    * @return Numero de agentes dentro del rango de vision dado.
    */
    public static int contarAgentes(Posicion w){
        int contador=0;
        ArrayList <Posicion> lista=calcularVision(w);
        for (Posicion par:lista){
            for (Agente ag:agenttes){
                if(par.getPosx()==ag.getPosAgente().getPosx()&&par.getPosy()==ag.getPosAgente().getPosy()){
                    contador+=1;
                }
            }
        }
        return contador;
    }
    
    /**
    * Metodo que permite moverse a los agentes dentro de su parche de vision.
    */
    public static void moverseAg(){
        for (Agente ag:agenttes){
            ArrayList<Posicion> coords=calcularVision(ag.getPosAgente());
            Random r=new Random();
            if (!coords.isEmpty()){
            int f=r.nextInt(coords.size());
            Posicion a=coords.get(f);
            if(vacios.contains(a)){
                Agente a1=new Agente(ag.getEstado(),a,ag.getProbDetEst(),ag.getPerjuicioPercibido(),ag.getAgravio(),ag.getAversionR(),ag.getRiesgoN());
                agenttes.add(a1);
                agenttes.remove(ag);
                vacios.remove(a);
            }
        }}
    }
    
    /**
    * Metodo que permite moverse a los policias dentro de su parche de vision.
    */
    public static void moverseCop(){
        Random r=new Random();
        for (Posicion cop:cops){
            //System.out.println("hola1");
            ArrayList<Posicion> campo=calcularVision(cop);
            if (!campo.isEmpty()){
            int f=r.nextInt(campo.size());
            Posicion a=campo.get(f);
                //System.out.println(a);
            if(vacios.contains(a)){
                //System.out.println("hola2");
                cops.add(a);
                cops.remove(cop);
                vacios.remove(a);
            }
        }}
    }
    
    /**
    * Metodo que comprueba si existen coordenadas vacias dentro del universo.
    * @return Verdadero si existen, falso lo contrario.
    */
    public static boolean verVacios(){
        for (int i=0;i<numFil;i++){
            for (int j=0;j<numCol;j++){
                boolean bandera=true;
                for(Agente ag:agenttes){
                    if(ag.getPosAgente().getPosx()==i&&ag.getPosAgente().getPosy()==j){
                        bandera=false;
                    }
                }
                for(Posicion cop:cops){
                    if (cop.getPosx()==i&cop.getPosy()==j){
                        bandera=false;
                    }
                }
                for (Posicion enc:encarcelados){
                    if(enc.getPosx()==i&enc.getPosy()==j){
                        bandera=false;
                    }
                }
                if (bandera){
                    return true;
                }
            }}return false;
    }
    
    /**
    * Metodo generador de archivos .csv por cada corrida del programa.
    * @return Un archivo .csv por cada corrida o turno simulado.
    */
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
        fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
    * Metodos de setters y getters del contructor de la clase.
    */
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

    public static ArrayList<Posicion> getTablero() {
        return tablero;
    }

    public static void setTablero(ArrayList<Posicion> tablero) {
        Universo.tablero = tablero;
    }

    public static ArrayList<Agente> getAgenttes() {
        return agenttes;
    }

    public static void setAgenttes(ArrayList<Agente> agenttes) {
        Universo.agenttes = agenttes;
    }

    public static ArrayList<Posicion> getCops() {
        return cops;
    }

    public static void setCops(ArrayList<Posicion> cops) {
        Universo.cops = cops;
    }

    public static ArrayList<Posicion> getVacios() {
        return vacios;
    }

    public static void setVacios(ArrayList<Posicion> vacios) {
        Universo.vacios = vacios;
    }

    public static ArrayList<Posicion> getEncarcelados() {
        return encarcelados;
    }

    public static void setEncarcelados(ArrayList<Posicion> encarcelados) {
        Universo.encarcelados = encarcelados;
    }
    
}
