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
    private double num_pol=Math.round(Rebellion.denPol*numFil*numCol);
    //El numero de agentes o civiles que tiene el universo.
    private double num_agentes=Math.round(Rebellion.denAg*numFil*numCol);;
    //Es un valor aleatorio dado al correr la simulacion.
    private double aversionR;
    //El estado define si el agente esta activo o inactivo.
    private static int estado=0;
    //La probabilidad de ser detenido segun el radio de vision.
    private double probDetEst;
    //Define cuan arriesgado es un civil dentro del universo.
    private double riesgoN;
    private static Posicion posAgente;
    public final double K=2.3;
    public final double LIMITE=0.1;
    //Fin de la definicion de metodos
    
    //Inicio del constructor de la clase Agente
    public Agente(int estado, Posicion posAgente) {
        super();
        this.perjuicioPercibido = Math.random();
        this.agravio = calcularAgravio();
        this.aversionR = Math.random();
        this.estado = estado;
        this.posAgente=posAgente;
       // this.probDetEst = calcularProbDetEst(Universo.contarCops(posAgente),Universo.contarAgentes(posAgente));
        //this.probDetEst = calcularProbDetEst(2,4);
        this.riesgoN = calcularRiesgo();
        calcularAgravio();
        verificarEstado();
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
    private double calcularAgravio() {
        double agravio=perjuicioPercibido*(1-legitimidad);
        return agravio;
    }

    private double calcularProbDetEst(int C, int A) {
        double probabilidad=1-Math.exp(-K*Math.round(C/A));
        return probabilidad;
    }

    private double calcularRiesgo() {
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

    public double getNum_pol() {
        return num_pol;
    }

    public void setNum_pol(double num_pol) {
        this.num_pol = num_pol;
    }

    public double getNum_agentes() {
        return num_agentes;
    }

    public void setNum_agentes(double num_agentes) {
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

    @Override
    public String toString() {
        return "Agente{" + "perjuicioPercibido=" + perjuicioPercibido + ", agravio=" + agravio + ", legitimidad=" + legitimidad + ", num_pol=" + num_pol + ", num_agentes=" + num_agentes + ", aversionR=" + aversionR + ", probDetEst=" + probDetEst + ", riesgoN=" + riesgoN + '}';
    }
    
    
}
