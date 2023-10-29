package br.edu.ifba.projeto.cenario02.borda.impl;

import br.edu.ifba.projeto.cenario02.borda.sensor.Sensor;
import br.edu.ifba.projeto.cenario02.modelo.LeituraVeiculo;

// Complexidade constante O(1)

public class SensorImpl extends Sensor{
    private static final int METROS_MINIMOS = 2000; // 2 KM
    private static final int METROS_MAXIMOS = 4000; // 4 KM

    public SensorImpl(String filial, String placaVeiculo, int totalDeLeituras) {
        super(filial, placaVeiculo, totalDeLeituras);
    }

    @Override
    public void gerarLeituras(String filial, String veiculo, int idLeitura, int tempo) {
        int distancia = randomizador.nextInt(METROS_MAXIMOS - METROS_MINIMOS + 1) + METROS_MINIMOS;

        LeituraVeiculo leitura = new LeituraVeiculo( idLeitura , tempo, distancia);
        System.out.println("Filial: "+ filial + " - Veiculo: " + veiculo + " - Leitura: " + idLeitura + " - Tempo: " + tempo + " - Distancia: " + distancia);
        leituras.add(leitura);
    }
}