/*
 * Rebellion Agent Model. Noviembre, 2017.
 * Copyright (c) 2017 Angel Encalada.
 * Escuela Superior Politecnica del Litoral
 * Todos los derechos reservados.
 */

package rebellion;
import java.util.Scanner;

/**
 * @author Angel Encalada
 * @param Programa principal que se encarga de la simulacion del universo.
 */

//Inicio de la clase.
public class Rebellion {
    //Densidad de los policias.
    static double denPol;
    //Densidad de los agentes o civiles.
    static double denAg;
    //Numero de filas del universo.
    static int numFil;
    //Numero de columnas del universo.
    static int numCol;
    //Radio de vision de los policias y agentes.
    static int radio;
    //Maximo numero de corridas del programa.
    static int maxTurno;
    //Indica si el universo se mueve o no, estatico o movil.
    static int movimiento;
    //Legitimidad que posee el gobierno en el universo.
    static double legitimidad;
    
    /**
     * @param Ejecutar el programa principal.
     */
    public static void main(String[] args) {
        ingresarDatos();
        salida();
        System.out.println("Salir");
    }
    
    /**
    * Metodo encargado de la validacion del ingreso de los datos al programa.
    */
    public static void ingresarDatos(){
        Scanner scan=new Scanner(System.in);
        
        System.out.println("Ingrese la densidad de Policias: ");
        while(!scan.hasNextDouble()){
            System.out.println("Numero invalido");
            System.out.println("Ingrese la densidad de Policias: ");
            scan.next();
        }
        Rebellion.denPol=scan.nextDouble();
        
        System.out.println("Ingrese la densidad de Agentes: ");
        while(!scan.hasNextDouble()){
            System.out.println("Numero invalido");
            System.out.println("Ingrese la densidad de Agentes: ");
            scan.next();
        }
        Rebellion.denAg=scan.nextDouble();
       
        System.out.println("Ingrese el numero de filas: ");
        while(!scan.hasNextInt()){
            System.out.println("Numero invalido");
            System.out.println("Ingrese el numero de filas: ");
            scan.next();
        }
        Rebellion.numFil=scan.nextInt();
        
        System.out.println("Ingrese el numero de columnas: ");
        while(!scan.hasNextInt()){
            System.out.println("Numero invalido");
            System.out.println("Ingrese el numero de columnas: ");
            scan.next();
        }
        Rebellion.numCol=scan.nextInt();
        
        System.out.println("Ingrese el numero maximo de turnos: ");
        while(!scan.hasNextInt()){
            System.out.println("Numero invalido");
            System.out.println("Ingrese el numero maximo de turnos: ");
            scan.next();
        }
        Rebellion.maxTurno=scan.nextInt();
        
        System.out.println("Ingrese el radio de vision: ");
        while(!scan.hasNextInt()){
            System.out.println("Numero invalido");
            System.out.println("Ingrese el radio de vision: ");
            scan.next();
        }
        Rebellion.radio=scan.nextInt();
        
        System.out.println("Ingrese la legitimidad del gobierno: ");
        while(!scan.hasNextDouble()){
            System.out.println("Numero invalido");
            System.out.println("Ingrese la legitimidad del gobierno: ");
            scan.next();
        }
        Rebellion.legitimidad=scan.nextDouble();
        
        System.out.println("Ingrese el estado de movimiento: ");
        while(!scan.hasNextInt()){
            System.out.println("Numero invalido");
            System.out.println("Ingrese el estado de movimiento: ");
            scan.next();
        }
        Rebellion.movimiento=scan.nextInt();
         
    }
    
    /**
    * Metodo encargado de gestionar el orden de simulacion del programa.
    */
    public static void salida(){
        int k=0;
        int i=0;
        int j=0;
            do{
            if(k>0){
               iniVar(); 
            }    
            Universo.colocarPolicias();
            i++;
            }while(i<=Math.round(denPol*numFil*numCol));
            //System.out.println("Termino policias");
            do{
            Universo.colocarAgentes();
            j++;
            }while(j<=Math.round(denAg*numFil*numCol));
            //System.out.println("Termino agentes");
        do{
            if (movimiento==1){
            Universo.moverseAg();
                //System.out.println("me movi ag");
            Universo.moverseCop();
                //System.out.println("me movi cop");
            }
            if(k>0){
            Universo.encarcelar();}
            //System.out.println("presoo");
            Universo.imprimirUniverso();
            //System.out.println("imprimi");
            Universo.generarCsv(k);
            System.out.println(Universo.contarActivos()+" "+Universo.contarInactivos()+" "+Universo.contarEncarcelados());
            System.out.println(k+" CORRIDA");
            System.out.println("+++++++++++++++++++++++++++++++");
            
            k++; 
        }while(k<=maxTurno);
    }
    
    /**
    * Metodo que gestiona la inicializacion de variables dentro de la simulacion.
    */
    public static void iniVar(){
        for (Agente ag:Universo.agenttes){
            ag.verificarEstado();
            ag.setAgravio(ag.calcularAgravio());
            ag.setProbDetEst(ag.calcularProbDetEst(Universo.contarCops(ag.getPosAgente()),Universo.contarAgentes(ag.getPosAgente())));
            ag.setRiesgoN(ag.calcularRiesgo());
        }
    }
}
//Fin de la clase.
