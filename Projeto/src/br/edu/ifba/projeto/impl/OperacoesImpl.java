package br.edu.ifba.projeto.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.projeto.operacoes.Operacoes;
import br.edu.ifba.projeto.ordenadores.Ordenador;

public class OperacoesImpl implements Operacoes<Veiculo, LeituraVeiculo> {

    //D.1
    @Override
    public void imprimirVeiculos(List<Veiculo> Veiculos) {
            for (Veiculo veiculo: Veiculos) {
                System.out.println(veiculo);
            }
    }
    //D.2
    @Override
    public void imprimirLeituraPorVeiculo(Map<Veiculo, List<LeituraVeiculo>>  leituras) {
        for (Veiculo veiculo: leituras.keySet()) {
            System.out.println("");
            System.out.println("------------------------------------");
            System.out.println("");
            System.out.println("Leituras do veiculo com placa: " + veiculo.getPlaca());
            for (LeituraVeiculo leitura: leituras.get(veiculo)) {
                System.out.println("");
                System.out.println(veiculo);
                System.out.println("Metros Percorridos: " + leitura.metrosPercorridos);
                System.out.println("Segundos Gastos: " + leitura.segundosGastos);
            }
        }
    }
    //D.3
    @Override
    public Map<Veiculo, List<LeituraVeiculo>> ordenar(Map<Veiculo, List<LeituraVeiculo>> leituras) {
        Map<Veiculo, List<LeituraVeiculo>> leiturasOrdenadas = new TreeMap<>();

        for (Veiculo veiculo: leituras.keySet()) {
            System.out.println("ordenando as leituras do veiculo: " + veiculo.getPlaca());

            List<LeituraVeiculo> leiturasParaOrdenar = leituras.get(veiculo);
            Ordenador<LeituraVeiculo> ordenador = new OrdenadorImpl(leiturasParaOrdenar);
            ordenador.ordenar();

            leiturasOrdenadas.put(veiculo, leiturasParaOrdenar);
        }

        return leiturasOrdenadas;
    }

    //D.4
    @Override
    public Map<Veiculo, List<LeituraVeiculo>> ordenarPorEficiencia(Map<Veiculo, List<LeituraVeiculo>> leituras) {
        Map<Veiculo, List<LeituraVeiculo>> leiturasOrdenadas = new TreeMap<>();

        for (Veiculo veiculo: leituras.keySet()) {
            System.out.println("ordenando as leituras do veiculo: " + veiculo.getPlaca());

            List<LeituraVeiculo> leiturasParaOrdenar = leituras.get(veiculo);
            Ordenador<LeituraVeiculo> ordenador = new OrdenadorImpl(leiturasParaOrdenar);
            ordenador.ordenar();

            leiturasOrdenadas.put(veiculo, leiturasParaOrdenar);
        }

        return leiturasOrdenadas;
    }
    
}
