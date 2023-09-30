package br.edu.ifba.projeto.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.projeto.ordenadores.Ordenador;

/**
 * classe auxiliadora para ordenacao
 * 
 * o algoritmo foi adaptado a partir do que se encontra disponibilizado em:
 * https://www.delftstack.com/howto/java/merge-sort-arraylist-java/
 * 
 * como se trata de um merge sort, a complexidade eh NLogN, porque primeiramente
 * o algoritmo divide a colecao de dados a ser ordenada e, apos a divisao,
 * junta cada sub-colecao de dados para chegar ao ordenamento.
 */
public class OrdenadorImpl extends Ordenador<LeituraVeiculo> {

    public OrdenadorImpl(List<LeituraVeiculo> leituras, String ordenarPor) {
        super(leituras, ordenarPor);
    }

    public void ordenar() {
        ordenar(0, leituras.size() - 1);
    }

    public void ordenar(int inicio, int fim) {
        if (inicio < fim && (fim - inicio) >= 1) {
            int meio = (fim + inicio) / 2;

            ordenar(inicio, meio);
            ordenar(meio + 1, fim);

            ordenar(inicio, meio, fim);
        }
    }

    private void ordenar(int inicio, int meio, int fim) {
        List<LeituraVeiculo> leiturasTemp = new ArrayList<>();

        int esquerda = inicio;
        int direita = meio + 1;

        //String ordenarPor;
        boolean condicao = false;

        while (esquerda <= meio && direita <= fim) {

            if ("segundos".equals(ordenarPor)) {
                condicao = leituras.get(esquerda).getSegundosGastos() <= leituras.get(direita).getSegundosGastos();
            } else if ("distancia".equals(ordenarPor)) {
                condicao = (leituras.get(esquerda).getMetrosPercorridos() <= leituras.get(direita).getMetrosPercorridos());
            }
            
            if (condicao) {
                leiturasTemp.add(leituras.get(esquerda));
                esquerda++;
            } else {
                leiturasTemp.add(leituras.get(direita));
                direita++;
            }
        }

        while (esquerda <= meio) {
            leiturasTemp.add(leituras.get(esquerda));
            esquerda++;
        }

        while (direita <= fim) {
            leiturasTemp.add(leituras.get(direita));
            direita++;
        }

        for (int i = 0; i < leiturasTemp.size(); inicio++) {
            leituras.set(inicio, leiturasTemp.get(i++));
        }
    }

    @Override
    public void ordenarPorEficiencia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenarPorEficiencia'");
    }

}