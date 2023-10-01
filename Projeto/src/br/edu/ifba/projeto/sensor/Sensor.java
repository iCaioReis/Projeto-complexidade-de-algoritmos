package br.edu.ifba.projeto.sensor;

import java.util.List;
/**
 * classe que determina as funcionalidades do sensor, 
 * cuja complexidade, de forma geral, é constante, O(1), 
 */
public interface Sensor<Velocimetro> {
    public List<Velocimetro> gerarLeituras(int totalLeituras);
}
