package br.edu.ifba.projeto.operacoes;

import java.util.List;
import java.util.Map;
//import br.edu.ifba.projeto.sensor.Sensor;

public interface Operacoes<Veiculo, LeituraVeiculo> {
    // d.1
    public void imprimirVeiculos(List<Veiculo> Veiculos);

    // d.2
    public void imprimirLeituraPorVeiculo(Map<Veiculo, List<LeituraVeiculo>> leituras);

    // d.3
    public Map<Veiculo, List<LeituraVeiculo>> ordenar(Map<Veiculo, List<LeituraVeiculo>> leituras);

    
}


