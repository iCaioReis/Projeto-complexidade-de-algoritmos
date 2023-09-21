package br.edu.ifba.projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.projeto.impl.SensorImpl;
import br.edu.ifba.projeto.impl.LeituraVeiculo;
import br.edu.ifba.projeto.impl.Veiculo;
import br.edu.ifba.projeto.sensor.Sensor;

public class App {
    private static final int TOTAL_DE_VEICULOS = 1;
    private static final int TOTAL_DE_LEITURAS = 100;
    public static void main(String[] args) throws Exception {

        Sensor<LeituraVeiculo> sensor = new SensorImpl();
        
        Map<Veiculo, List<LeituraVeiculo>> leiturasPorVeiculo = new TreeMap<>();

        for (int i = 0; i < TOTAL_DE_VEICULOS; i++) {
            String id = (i + 1) + "";

            leiturasPorVeiculo.put(new Veiculo(id, "Placa #" + id), 
                sensor.gerarLeituras(TOTAL_DE_LEITURAS)
            );
        }

        System.out.println(leiturasPorVeiculo);
    }
}
