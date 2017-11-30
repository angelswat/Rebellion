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
        int i=0;
        int j=0;
        int k=0;
        do{
            do{
            Universo.colocarPolicias();
            i++;
            }while(i<=Math.round(denPol*100));
            do{
            Universo.colocarAgentes();
            }while(j<=Math.round(denAg*100));
            Universo.imprimirUniverso();
            Universo.generarCsv(maxTurno, numFil, numFil, numFil); //corregir valores
            Universo.encerarTablero();
            k++;
        }while(k<=maxTurno);
    }
    
    public static void ingresarDatos(){
        Scanner scan=new Scanner(System.in);
        double denPol;
        double denAg=0;
        int numFil;
        int numCol;
        int maxTurno;
        int radio;
        double legitimidad;
        int movimiento;
        
        System.out.println("Ingresar denpol:");
        if (scan.hasNextDouble()) {
            Rebellion.denPol= scan.nextDouble();
        }
        
        System.out.println("Ingresar denag:");
        if (scan.hasNextDouble()) {
            Rebellion.denAg = scan.nextDouble();
        }
        System.out.println("Ingresar filas:");
        if (scan.hasNextInt()) {
            Rebellion.numFil = scan.nextInt();
        }
        System.out.println("Ingresar columnas:");
        if (scan.hasNextInt()) {
            Rebellion.numCol = scan.nextInt();
        }
        System.out.println("Ingresar turnos:");
        if (scan.hasNextInt()) {
            Rebellion.maxTurno = scan.nextInt();
        }
        System.out.println("Ingresar radio:");
        if (scan.hasNextInt()) {
            Rebellion.radio = scan.nextInt();
        }
        System.out.println("Ingresar legitimidad:");
        if (scan.hasNextDouble()) {
            Rebellion.legitimidad = scan.nextDouble();
        }
        System.out.println("Ingresar movimiento:");
        if (scan.hasNextInt()) {
            Rebellion.movimiento = scan.nextInt();
        }    
    }
    
    
    
    
}
