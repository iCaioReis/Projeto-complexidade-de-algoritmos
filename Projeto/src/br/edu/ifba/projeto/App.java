package br.edu.ifba.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.projeto.impl.SensorImpl;
import br.edu.ifba.projeto.impl.LeituraVeiculo;
import br.edu.ifba.projeto.impl.OperacoesImpl;
import br.edu.ifba.projeto.impl.Veiculo;
import br.edu.ifba.projeto.sensor.Sensor;
import br.edu.ifba.projeto.operacoes.Operacoes;

public class App {
    private static final int TOTAL_DE_VEICULOS = 5;
    private static final int TOTAL_DE_LEITURAS = 100;
    public static void main(String[] args) throws Exception {

        Sensor<LeituraVeiculo> sensor = new SensorImpl();
        Operacoes<Veiculo, LeituraVeiculo> operacoes = new OperacoesImpl();
        
        Map<Veiculo, List<LeituraVeiculo>> leiturasPorVeiculo = new TreeMap<>();

        for (int i = 0; i < TOTAL_DE_VEICULOS; i++) {
            String id = (i + 1) + "";

            leiturasPorVeiculo.put(new Veiculo(id, "Placa #" + id), 
                sensor.gerarLeituras(TOTAL_DE_LEITURAS)
            );
        }

        //Testando d.1
        //operacoes.imprimirVeiculos(new ArrayList<Veiculo>(leiturasPorVeiculo.keySet()));

        //Testando d.2
        operacoes.imprimirLeituraPorVeiculo(leiturasPorVeiculo);
    }
}
