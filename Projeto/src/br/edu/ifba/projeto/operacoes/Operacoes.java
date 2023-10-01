package br.edu.ifba.projeto.operacoes;

import java.util.List;
import java.util.Map;
import br.edu.ifba.projeto.impl.Filial;

/**
 * classe que determina as funcionalidades dos operadores, 
 * cuja complexidade, de forma geral, é constante, O(1), 
 */

public interface Operacoes<Veiculo, LeituraVeiculo> {
    // d.1
    public void imprimirVeiculos(Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> Filiais);

    // d.2
    public void imprimirLeituraPorVeiculo(Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> leituras);

    // d.3
    public Map<Veiculo, List<LeituraVeiculo>> ordenar(Map<Veiculo, List<LeituraVeiculo>> leituras, String ordenarPor);

    // d.4
    public void exibirEficiencia(Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> leituras);
}


