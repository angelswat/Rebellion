/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebellion;

/**
 *
 * @author Usuario
 */
public class Agente {
    private double perjuicioPercibido;
    private double agravio;
    private int legitimidad;
    private int num_pol;
    private int num_agentes;
    private double aversionR;
    private int estado;
    private double probDetEst;
    private double riesgoN;

    public Agente(int legitimidad, int num_pol, int num_agentes) {
        this.perjuicioPercibido = Math.random();
        this.agravio = calcularAgravio();
        this.legitimidad = legitimidad;
        this.num_pol = num_pol;
        this.num_agentes = num_agentes;
        this.aversionR = aversionR;
        this.estado = estado;
        this.probDetEst = calcularProbDetEst(num_pol,num_agentes);
        this.riesgoN = calcularRiesgo();
        verificarEstado();
    }

    private double calcularAgravio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private double calcularProbDetEst(int num_pol, int num_agentes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private double calcularRiesgo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void verificarEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
