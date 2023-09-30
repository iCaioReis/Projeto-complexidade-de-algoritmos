package br.edu.ifba.projeto.ordenadores;
import java.util.List;
/**
 * classe que determina as funcionalidades do ordenador, 
 * cuja complexidade, de forma geral, eh constante, O(1)
 */
public abstract class Ordenador<Sensor> {

    protected List<Sensor> leituras = null;
    protected String ordenarPor = null;

    public Ordenador(List<Sensor> leituras, String ordenarPor) {
        this.leituras = leituras;
        this.ordenarPor = ordenarPor;
    }

    public List<Sensor> getLeituras() {
        return this.leituras;
    }
    
    public abstract void ordenar();

    public abstract void ordenarPorEficiencia();
}
