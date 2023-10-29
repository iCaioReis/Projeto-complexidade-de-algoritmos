package br.edu.ifba.projeto.cenario02.borda.impl;
import java.util.List;

import br.edu.ifba.projeto.cenario02.modelo.LeituraVeiculo;
// Complexidade  linear, O(N)
public class medirEficienciaImpl{

    public float medirEficienciaVeiculo(List<LeituraVeiculo> leiturasVeiculo){
        int somaMetrosTotal = 0;
        int somaSegundosTotal = 0;
        int somaLitrosCombustivelTotal = leiturasVeiculo.size();

        for (LeituraVeiculo leitura : leiturasVeiculo) {
            somaMetrosTotal += leitura.metrosPercorridos;
            somaSegundosTotal += leitura.getSegundosGastos();
        }
        float eficiencia = (float)somaMetrosTotal/somaLitrosCombustivelTotal/somaSegundosTotal;

        return eficiencia;
    };
}