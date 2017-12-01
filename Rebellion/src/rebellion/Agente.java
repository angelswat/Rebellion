/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebellion;
import java.util.Random;
/**
 * @author Angel Encalada
 * @param La clase Agente define las variables que tomaran los civiles.
 */

//Definicion de metodos de la clase Agente
public class Agente extends Persona {
    //Perjucio percibido al momento de nacer, es una valor random.
    private double perjuicioPercibido;
    //El agravio es un valor determinado con el perjucio percibido y la
    //legitimidad del gobierno.
    private double agravio;
    //La legitimidad es un valor que define el usuario al iniciar la simulacion.
    private static double legitimidad=Rebellion.legitimidad;
    //Es un valor aleatorio dado al correr la simulacion.
    private double aversionR;
    //El estado define si el agente esta activo o inactivo.
    private int estado;
    //La probabilidad de ser detenido segun el radio de vision.
    private double probDetEst;
    //Define cuan arriesgado es un civil dentro del universo.
    private double riesgoN;
    private Posicion posAgente;
    public static final double K=2.3;
    public static final double LIMITE=0.1;
    //Fin de la definicion de metodos
    
    //Inicio del constructor de la clase Agente
    public Agente(int estado, Posicion posAgente,double probabilidad,double perjuicioPercibido,double agravio,double aversion,double riesgo) {
        super();
        this.perjuicioPercibido=perjuicioPercibido=Math.random();
        this.agravio = calcularAgravio();
        this.aversionR = aversion;
        this.estado = estado;
        verificarEstado();
        this.posAgente=posAgente;
        this.probDetEst = probabilidad;
        this.riesgoN = calcularRiesgo();
        
    }
/*
    public Agente(int estado,Posicion posAgente) {
        this.estado = estado;
        this.posAgente = posAgente;
        verificarEstado();
    }
    //Fin del constructor de la clase
    */
    //
    protected double calcularAgravio() {
        double agravio=perjuicioPercibido*(1-legitimidad);
        return agravio;
    }

    protected double calcularProbDetEst(int C, int A) {
        double probabilidad=1-Math.exp(-K*Math.round(C/A));
        return probabilidad;
    }

    protected double calcularRiesgo() {
        double riesgoNeto=this.aversionR*this.probDetEst;
        return riesgoNeto;
    }

    public void verificarEstado() {
        if (this.agravio-this.riesgoN>LIMITE){
            this.estado=1;
        }
        else if(this.agravio-this.riesgoN<=0.1){
            this.estado=0;
        }
    }
    
    public double getPerjuicioPercibido(){
        return perjuicioPercibido;
    }

    public void setPerjuicioPercibido(double perjuicioPercibido) {
        this.perjuicioPercibido = perjuicioPercibido;
    }

    public double getAgravio() {
        return agravio;
    }

    public void setAgravio(double agravio) {
        this.agravio = agravio;
    }

    public double getLegitimidad() {
        return legitimidad;
    }

    public void setLegitimidad(double legitimidad) {
        this.legitimidad = legitimidad;
    }
    
    public double getAversionR() {
        return aversionR;
    }

    public void setAversionR(double aversionR) {
        this.aversionR = aversionR;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getProbDetEst() {
        return probDetEst;
    }

    public void setProbDetEst(double probDetEst) {
        this.probDetEst = probDetEst;
    }

    public double getRiesgoN() {
        return riesgoN;
    }

    public void setRiesgoN(double riesgoN) {
        this.riesgoN = riesgoN;
    }
    
    public Posicion getPosAgente(){
        return posAgente;
    }
    
    public void setPosAgente(Posicion posAgente){
        this.posAgente=posAgente;
    }

    @Override
    public String toString() {
        return "Agente{" + "perjuicioPercibido=" + perjuicioPercibido + ", agravio=" + agravio + ", aversionR=" + aversionR + ", probDetEst=" + probDetEst + ", riesgoN=" + riesgoN + '}';
    }
}
