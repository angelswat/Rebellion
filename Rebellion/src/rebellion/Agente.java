/*
 * Rebellion Agent Model. Noviembre, 2017.
 * Copyright (c) 2017 Angel Encalada.
 * Escuela Superior Politecnica del Litoral
 * Todos los derechos reservados.
 */

package rebellion;

/**
 * @author Angel Encalada
 * @param Definir los atributos y metodos exclusivos para Agentes.
 */

//Inicio de la clase.
public class Agente extends Persona {
    //Perjucio percibido al momento de nacer, es un valor random.
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
    //Objeto Agente que se guia por una coordenada dentro del universo.
    private Posicion posAgente;
    //Constante proporcional K.
    public static final double K=2.3;
    //Limite de agravio para todo el universo.
    public static final double LIMITE=0.1;
    //Fin de la definicion de metodos
    
    //Constructor de la clase Agente.
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
    
    /**
    * Metodo calculador del agravio de un agente al nacer.
    * @return Agravio del civil, en base al perjuicio y legitimidad del gobierno.
    */
    protected double calcularAgravio() {
        double agravio=perjuicioPercibido*(1-legitimidad);
        return agravio;
    }

    /**
    * Metodo calculador de la probabilidad de detencion de un civil.
    * @return Probabilidad basada en el numero de policias y civiles en un parche.
    */
    protected double calcularProbDetEst(int C, int A) {
        double probabilidad=1-Math.exp(-K*Math.round(C/A));
        return probabilidad;
    }

    /**
    * Metodo calculador del riesgo neto que tiene un agente al nacer.
    * @return Riesgo del agente a ser encarcelado si se subleva.
    */
    protected double calcularRiesgo() {
        double riesgoNeto=this.aversionR*this.probDetEst;
        return riesgoNeto;
    }

    /**
    * Metodo verificador del estado de un agente, si es activo o pasivo.
    * @return 1 si esta rebelado o 0 si es pasivo o inactivo.
    */
    public void verificarEstado() {
        if (this.agravio-this.riesgoN>LIMITE){
            this.estado=1;
        }
        else if(this.agravio-this.riesgoN<=0.1){
            this.estado=0;
        }
    }
    
    /**
    * Metodos getter y setter del constructor de la clase Agente.
    */
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

    /**
    * Metodo sobreescrito ToString para en caso de imprimir un objeto de la clase.
    * @return Cadena de texto con los atributos del objeto de la clase.
    */
    @Override
    public String toString() {
        return "Agente{" + "perjuicioPercibido=" + perjuicioPercibido + ", agravio=" + agravio + ", aversionR=" + aversionR + ", probDetEst=" + probDetEst + ", riesgoN=" + riesgoN + '}';
    }
}
//Fin de la clase.