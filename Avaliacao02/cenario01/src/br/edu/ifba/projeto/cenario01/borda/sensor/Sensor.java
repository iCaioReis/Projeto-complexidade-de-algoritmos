package br.edu.ifba.projeto.cenario01.borda.sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ifba.projeto.cenario01.modelo.LeituraVeiculo;

public abstract class Sensor implements Runnable {
    protected static Random randomizador = new Random();
    protected List<LeituraVeiculo> leituras = new ArrayList<>();
    protected String filial, placaVeiculo  = "";
    protected int totalDeLeituras = 0;
    private static final int SEGUNDOS_MINIMOS = 100; //1 MINUTOS E 40 SEGUNDOS
    private static final int SEGUNDOS_MAXIMOS = 200; // 3 MIN E 20 SEGUNDOS
    // Complexidade constante O(1)
    public Sensor(String filial, String placaVeiculo, int totalDeLeituras) {
        this.totalDeLeituras = totalDeLeituras;
        this.filial = filial;
        this.placaVeiculo = placaVeiculo;
    }
    // Complexidade constante O(1)
    public void gerarLeituras(String filial, String placaVeiculo, int idLeitura, int tempo) {
    }
    // Complexidade constante O(1)
    public List<LeituraVeiculo> getLeituras(){
        return leituras;
    }
    // Complexidade  linear, O(N^2), pois existe um laço de repetição O(N), que chama o método
    //gerarLeituras, de complexidade O(N)
    @Override
    public void run() {
        for (int i = 0; i < totalDeLeituras; i++) {
            int tempo = randomizador.nextInt(SEGUNDOS_MAXIMOS - SEGUNDOS_MINIMOS + 1) + SEGUNDOS_MINIMOS;

            try {
                Thread.sleep(tempo*10);
                this.gerarLeituras(this.filial, this.placaVeiculo, i + 1, tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
