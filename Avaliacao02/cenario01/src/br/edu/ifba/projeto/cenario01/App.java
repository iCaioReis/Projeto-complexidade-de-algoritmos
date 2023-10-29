package br.edu.ifba.projeto.cenario01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.projeto.cenario01.modelo.Filial;
import br.edu.ifba.projeto.cenario01.modelo.LeituraVeiculo;
import br.edu.ifba.projeto.cenario01.modelo.Veiculo;
import br.edu.ifba.projeto.cenario01.borda.impl.GeradorDeDadosImpl;
import br.edu.ifba.projeto.cenario01.nuvem.impl.ExecutorImpl;


public class App {
    // Configurações para gerar dados
    private static final int TOTAL_DE_FILIAIS = 2;
    private static final int TOTAL_DE_VEICULOS = 5;
    private static final int TOTAL_DE_LEITURAS = 10;

    private static Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> filiais = new TreeMap<>();
    // Complexidade  linear, O(N^2), pois existe um for que chama o método GeradorDeDadosImpl, que por sua vez é de complexidade O(N)
    public static Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> gerarFiliais() throws InterruptedException {
        List<Thread> executoresFiliais = new ArrayList<>();
        Map<Filial, GeradorDeDadosImpl> filialVeiculos = new TreeMap<>();
        Map<Filial, Map<Veiculo, List<LeituraVeiculo>>> filiais = new TreeMap<>();

        for (int i = 0; i < TOTAL_DE_FILIAIS; i++) {

            String idFilial = (i + 1) + "";
            String nomeFilial = "Filial #" + idFilial;
            Filial filial = new Filial(idFilial, nomeFilial);
            GeradorDeDadosImpl filialVeiculo = new GeradorDeDadosImpl(nomeFilial, TOTAL_DE_VEICULOS, TOTAL_DE_LEITURAS);
            Thread executor = new Thread(filialVeiculo);
            executoresFiliais.add(executor);
            filialVeiculos.put(filial, filialVeiculo);
            executor.start();
        }

        for (Thread executor : executoresFiliais) {
            executor.join();
        }

        for (Map.Entry<Filial, GeradorDeDadosImpl> entry : filialVeiculos.entrySet()){
            Filial filial = entry.getKey();
            GeradorDeDadosImpl dados = entry.getValue();
            filiais.put(filial, dados.getFilial());
        }

        return filiais;
    }
 
    public static void main(String[] args) throws Exception {
        filiais = gerarFiliais();
        ExecutorImpl executor = new ExecutorImpl();
        executor.exibirEficiencia(filiais);

    }
}