/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebellion;
import java.util.Scanner;
/**
 *
 * @author Angel Encalada
 */
public class Rebellion {
    static double denPol;
    static double denAg;
    static int numFil;
    static int numCol;
    static int radio;
    static int maxTurno;
    static int movimiento;
    static double legitimidad;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ingresarDatos();
        salida();
        System.out.println("Salir");
    }
    
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
    
    public static void salida(){
        int k=0;
        int i=0;
        int j=0;
            do{
            Universo.colocarPolicias();
            i++;
            }while(i<=Math.round(denPol*numFil*numCol));
            System.out.println("Termino policias");
            do{
            Universo.colocarAgentes();
            j++;
            }while(j<=Math.round(denAg*numFil*numCol));
            System.out.println("Termino agentes");
        do{
            if (movimiento==1){
            Universo.moverseAg();
                System.out.println("me movi ag");
            Universo.moverseCop();
                System.out.println("me movi cop");
            }
            Universo.encarcelar();
            System.out.println("presoo");
            Universo.imprimirUniverso();
            System.out.println("imprimi");
            Universo.generarCsv(k);
            System.out.println(k+" CORRIDA");
            
            k++; 
        }while(k<=maxTurno);
    }
}
