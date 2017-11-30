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
    private double legitimidad=Rebellion.legitimidad;
    //El numero de policias que tiene el universo.
    private int num_pol;
    //El numero de agentes o civiles que tiene el universo.
    private int num_agentes;
    //Es un valor aleatorio dado al correr la simulacion.
    private double aversionR;
    //El estado define si el agente esta activo o inactivo.
    private static int estado;
    //La probabilidad de ser detenido segun el radio de vision.
    private double probDetEst;
    //Define cuan arriesgado es un civil dentro del universo.
    private double riesgoN;
    
    private static Posicion posAgente;
    //Fin de la definicion de metodos
    
    //Inicio del constructor de la clase Agente
    public Agente(double legitimidad, int num_pol, int num_agentes) {
        super();
        this.perjuicioPercibido = Math.random();
        this.agravio = calcularAgravio();
        //this.legitimidad = legitimidad;
        this.num_pol = num_pol;
        this.num_agentes = num_agentes;
        this.aversionR = aversionR;
        this.estado = estado;
        this.probDetEst = calcularProbDetEst(num_pol,num_agentes);
        this.riesgoN = calcularRiesgo();
        verificarEstado();
    }

    public Agente(int estado,Posicion posAgente) {
        this.estado = estado;
        this.posAgente = posAgente;
    }

    
    //Fin del constructor de la clase
    
    //
    public double calcularAgravio() {
        double agravio=perjuicioPercibido*(1-legitimidad);
        return agravio;
    }

    public double calcularProbDetEst(int C, int A) {
        double probabilidad=1-Math.exp(-2.3*Math.round(C/A));
        return probabilidad;
    }

    private double calcularRiesgo() {
        double riesgoNeto=this.aversionR*this.probDetEst;
        return riesgoNeto;
    }

    private void verificarEstado() {
        if (this.agravio-this.riesgoN>0.1){
            this.estado=1;
        }
        else{
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

    public int getNum_pol() {
        return num_pol;
    }

    public void setNum_pol(int num_pol) {
        this.num_pol = num_pol;
    }

    public int getNum_agentes() {
        return num_agentes;
    }

    public void setNum_agentes(int num_agentes) {
        this.num_agentes = num_agentes;
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
}
