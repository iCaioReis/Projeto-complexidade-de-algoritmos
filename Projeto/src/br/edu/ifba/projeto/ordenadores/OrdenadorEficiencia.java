package br.edu.ifba.projeto.ordenadores;

import java.util.List;

public abstract class OrdenadorEficiencia<Sensor> {
    protected List<Sensor> leituras = null;

    public OrdenadorEficiencia(List<Sensor> leituras) {
        this.leituras = leituras;
    }

    public List<Sensor> getLeituras() {
        return this.leituras;
    }
    
    public abstract void ordenar();
}
