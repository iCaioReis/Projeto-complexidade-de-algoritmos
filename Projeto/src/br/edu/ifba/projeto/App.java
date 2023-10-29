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
import br.edu.ifba.projeto.impl.Filial;
import java.util.Map.Entry;

public class App {
    //Configurações para gerar dados
    private static final int TOTAL_DE_FILIAIS = 2;
    private static final int TOTAL_DE_VEICULOS = 5;
    private static final int TOTAL_DE_LEITURAS = 10;

    
    // Algoritmo de complexidade exponencial O(n^2), pois hé um for aninhado a outro for.
    public static void main(String[] args) throws Exception {

        Sensor<LeituraVeiculo> sensor = new SensorImpl();
        Operacoes<Veiculo, LeituraVeiculo> operacoes = new OperacoesImpl();

        Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> filiais = new TreeMap<>();
        // Map<Veiculo, List<LeituraVeiculo>> leiturasPorVeiculo = new TreeMap<>();

        for (int i = 0; i < TOTAL_DE_FILIAIS; i++) {
            String id = (i + 1) + "";
            Map<Veiculo, List<LeituraVeiculo>> leiturasPorVeiculo = new TreeMap<>();

            for (int j = 0; j < TOTAL_DE_VEICULOS; j++) {
                String idVeiculo = (j + 1) + "";

                leiturasPorVeiculo.put(new Veiculo(idVeiculo, "Placa #" + idVeiculo), sensor.gerarLeituras(TOTAL_DE_LEITURAS));
            }
            filiais.put(new Filial(id, "Filial #" + id), leiturasPorVeiculo);
        }
        
        // Testando d.1
        //operacoes.imprimirVeiculos(filiais);

        // Testando d.2
        operacoes.imprimirLeituraPorVeiculo(filiais);

        // Testando d.3 - Ordenando segundos ou distancia

        /*
        Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> leiturasOrdenadasFiliais = new TreeMap<>();

        for (Map.Entry<Filial, Map<Veiculo, List<LeituraVeiculo>>> filialEntry : filiais.entrySet()) {
            Filial filial = filialEntry.getKey();
            Map<Veiculo, List<LeituraVeiculo>> leiturasPorVeiculo = filialEntry.getValue();

            System.out.println("Filial: " + filial.getNome());

            // Ordenar as leituras por veículo
            Map<Veiculo, List<LeituraVeiculo>> leiturasOrdenadas = operacoes.ordenar(leiturasPorVeiculo, "distancia"); //"segundos" ou "distancia"

            leiturasOrdenadasFiliais.put(new Filial(filial.getId(), filial.getNome()), leiturasOrdenadas);
        }

        // Imprimir as leituras por veículo
        operacoes.imprimirLeituraPorVeiculo(leiturasOrdenadasFiliais);
        */

        // Testando d.4
        operacoes.exibirEficiencia(filiais);
    }
}
