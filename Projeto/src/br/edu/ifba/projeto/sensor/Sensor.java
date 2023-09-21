package br.edu.ifba.projeto.sensor;

import java.util.List;

public interface Sensor<Velocimetro> {
    public List<Velocimetro> gerarLeituras(int totalLeituras);
}
