package br.edu.ifba.projeto.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.projeto.operacoes.Operacoes;
import br.edu.ifba.projeto.ordenadores.Ordenador;

public class OperacoesImpl implements Operacoes<Veiculo, LeituraVeiculo> {

    //D.1
    // Método de complexidade exponencial O(n^2), pois hé um for aninhado a outro for.
    @Override
    public void imprimirVeiculos(Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> filiais) {

        for (Filial filial : filiais.keySet()) {
            System.out.println("---------------------------------");
            System.out.println("Filial: " + filial.getNome());

            Map<Veiculo, List<LeituraVeiculo>> veiculosFilial = filiais.get(filial);

            for (Veiculo veiculo : veiculosFilial.keySet()) {
                System.out.println("   Veículo: " + veiculo.getPlaca());
            }
            System.out.println("---------------------------------");
        }
    }
    //D.2
    // Método de complexidade cúbica O(n^3), pois hé um for aninhado a outro for, que está aninhado a outro for. 
    @Override
    public void imprimirLeituraPorVeiculo(Map<Filial, Map<Veiculo, List<LeituraVeiculo>>>  leituras) {

        for (Filial filial : leituras.keySet()) {
            System.out.println("---------------------------------");
            System.out.println("Filial: " + filial.getNome());

            Map<Veiculo, List<LeituraVeiculo>> veiculosFilial = leituras.get(filial);

            for (Veiculo veiculo : veiculosFilial.keySet()) {
                System.out.println("\n  Veículo: " + veiculo.getPlaca());

                List<LeituraVeiculo> listaLeituras = veiculosFilial.get(veiculo);

                for (LeituraVeiculo leitura : listaLeituras) {
                    System.out.println("\n    Metros Percorridos: " + leitura.metrosPercorridos);
                    System.out.println("    Segundos Gastos: " + leitura.segundosGastos);
                }
            }

            System.out.println("---------------------------------");
        }
    }
    //D.3
    // complexidade linear O(N*logN)por haver um For que chama o método ordenar de complexidade O(NlogN).
    @Override
    public Map<Veiculo, List<LeituraVeiculo>> ordenar(Map<Veiculo, List<LeituraVeiculo>> leituras, String ordenarPor) {
        Map<Veiculo, List<LeituraVeiculo>> leiturasOrdenadas = new TreeMap<>();

        for (Veiculo veiculo: leituras.keySet()) {
            System.out.println("ordenando as leituras do veiculo: " + veiculo.getPlaca());

            List<LeituraVeiculo> leiturasParaOrdenar = leituras.get(veiculo);
            Ordenador<LeituraVeiculo> ordenador = new OrdenadorImpl(leiturasParaOrdenar, ordenarPor);
            ordenador.ordenar();

            leiturasOrdenadas.put(veiculo, leiturasParaOrdenar);
        }

        return leiturasOrdenadas;
    }

    // Método de complexidade cúbica O(n^3), pois hé um for aninhado a outro for, que está aninhado a outro for. 
    // Devido a complexidade do algoritmo, não é possivel que o mesmo gere uma necessidade de processamento via brute force.
    //D.4
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
