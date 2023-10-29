package br.edu.ifba.projeto.cenario01.nuvem.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.projeto.cenario01.modelo.Filial;
import br.edu.ifba.projeto.cenario01.modelo.LeituraVeiculo;
import br.edu.ifba.projeto.cenario01.modelo.Veiculo;
import br.edu.ifba.projeto.cenario01.nuvem.executor.Executor;

public class ExecutorImpl  implements Executor{
    // Método de complexidade cúbica O(n^3), pois hé um for aninhado a outro for, que está aninhado a outro for. 
    @Override
    public void exibirEficiencia(Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> leituras) {
    
        for (Filial filial : leituras.keySet()) {
            Map<Veiculo, Float> eficienciaPorVeiculo = new TreeMap<>();
            int totalVeiculos = leituras.get(filial).size();
            float eficienciaTotal = 0;
            float eficienciaMedia = 0;

            System.out.println("---------------------------------");
            System.out.println("Filial: " + filial.getNome());

            Map<Veiculo, List<LeituraVeiculo>> veiculosFilial = leituras.get(filial);

            for (Veiculo veiculo : veiculosFilial.keySet()) {
                int somaMetrosTotal = 0;
                int somaSegundosTotal = 0;
                List<LeituraVeiculo> listaLeituras = veiculosFilial.get(veiculo);
                int somaLitrosCombustivelTotal = listaLeituras.size();

                for (LeituraVeiculo leitura : listaLeituras) {
                    somaMetrosTotal += leitura.metrosPercorridos;
                    somaSegundosTotal += leitura.getSegundosGastos();
                }

                float eficiencia = (float)somaMetrosTotal/somaLitrosCombustivelTotal/somaSegundosTotal;

                eficienciaTotal += eficiencia;;
                eficienciaPorVeiculo.put(veiculo, eficiencia);
            }
            eficienciaMedia = eficienciaTotal / totalVeiculos;

            for (Map.Entry<Veiculo, Float> entry : eficienciaPorVeiculo.entrySet()) {
                Veiculo veiculo = entry.getKey();
                Float eficiencia = entry.getValue();
    
                System.out.println("\nVeículo: " + veiculo.getPlaca() + " - Eficiência: " + eficiencia);
    
                if (eficiencia == eficienciaMedia) {
                    System.out.println("Eficiência normal");
                }else if (eficiencia > eficienciaMedia) {
                    System.out.println("Eficiência acima da média");
                } else{
                    System.out.println("Eficiência abaixo da média");
                }
            }
            System.out.println("\n\nEficiencia media da filial: " + eficienciaMedia);
        }
    }
}