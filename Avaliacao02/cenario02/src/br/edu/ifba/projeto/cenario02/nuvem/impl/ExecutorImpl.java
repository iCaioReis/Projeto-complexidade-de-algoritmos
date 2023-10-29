package br.edu.ifba.projeto.cenario02.nuvem.impl;

import java.util.Map;
import br.edu.ifba.projeto.cenario02.modelo.Filial;
import br.edu.ifba.projeto.cenario02.modelo.Veiculo;
import br.edu.ifba.projeto.cenario02.nuvem.executor.Executor;

public class ExecutorImpl  implements Executor{
    // Método de complexidade cúbica O(n^2), pois hé um for aninhado a outro for.
    @Override
    public void exibirEficiencia(Map<Filial, Map<Veiculo, Float>> leituras) {
    
        for (Filial filial : leituras.keySet()) {
            int totalVeiculos = leituras.get(filial).size();
            float eficienciaTotal = 0;
            float eficienciaMedia = 0;

            System.out.println("---------------------------------");
            System.out.println("Filial: " + filial.getNome());

            Map<Veiculo, Float> veiculosFilial = leituras.get(filial);

            for (float valorEficiencia : veiculosFilial.values()) {
                eficienciaTotal += valorEficiencia;
            }

            eficienciaMedia = eficienciaTotal / totalVeiculos;

            for (Map.Entry<Veiculo, Float> entry : veiculosFilial.entrySet()) {
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