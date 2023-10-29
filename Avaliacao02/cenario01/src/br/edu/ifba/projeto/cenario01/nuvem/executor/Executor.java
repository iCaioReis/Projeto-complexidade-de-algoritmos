package br.edu.ifba.projeto.cenario01.nuvem.executor;

import java.util.List;
import java.util.Map;

import br.edu.ifba.projeto.cenario01.modelo.Filial;
import br.edu.ifba.projeto.cenario01.modelo.LeituraVeiculo;
import br.edu.ifba.projeto.cenario01.modelo.Veiculo;
// Complexidade constante O(1)
public interface Executor{
    public void exibirEficiencia(Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> leituras);
}