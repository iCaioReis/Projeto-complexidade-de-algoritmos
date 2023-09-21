package br.edu.ifba.projeto.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ifba.projeto.sensor.Sensor;

public class SensorImpl implements Sensor<LeituraVeiculo> {
    private static final int TEMPO_MEDI0_SEGUNDOS = 150; //2 MINUTOS E 30 SEGUNDOS
    private static final int OSCILACAO_MAXIMA_TEMPO = 30;
    private static final int DISTANCIA_MEDIA_METROS = 3000; //2 MINUTOS E 30 SEGUNDOS
    private static final int OSCILACAO_MAXIMA_DISTANCIA = 1000;

    @Override
    public List<LeituraVeiculo> gerarLeituras(int totalLeituras) {
        Random randomizador = new Random();
        List<LeituraVeiculo> leituras = new ArrayList<>();

        for (int i = 0; i < totalLeituras; i++) {
            int oscilacaoTempo = TEMPO_MEDI0_SEGUNDOS * randomizador.nextInt(OSCILACAO_MAXIMA_TEMPO)/100;
            int oscilacaoDistancia = DISTANCIA_MEDIA_METROS * randomizador.nextInt(OSCILACAO_MAXIMA_DISTANCIA)/100;

            int tempo = (randomizador.nextBoolean()? TEMPO_MEDI0_SEGUNDOS + oscilacaoTempo: TEMPO_MEDI0_SEGUNDOS - oscilacaoTempo);
            int distancia = (randomizador.nextBoolean()? DISTANCIA_MEDIA_METROS + oscilacaoDistancia: DISTANCIA_MEDIA_METROS - oscilacaoDistancia);

            LeituraVeiculo leitura = new LeituraVeiculo(i + 1, tempo, distancia);
            leituras.add(leitura);
        }

        return leituras;
    }
}
