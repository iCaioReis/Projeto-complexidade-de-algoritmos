package br.edu.ifba.projeto.cenario02.nuvem.executor;

import java.util.Map;

import br.edu.ifba.projeto.cenario02.modelo.Filial;
import br.edu.ifba.projeto.cenario02.modelo.Veiculo;
// Complexidade constante O(1)
public interface Executor{
    public void exibirEficiencia(Map<Filial, Map<Veiculo, Float>> leituras);
}