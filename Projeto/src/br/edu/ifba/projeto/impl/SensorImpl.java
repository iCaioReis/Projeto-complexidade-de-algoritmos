package br.edu.ifba.projeto.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ifba.projeto.sensor.Sensor;

public class SensorImpl implements Sensor<LeituraVeiculo> {

    private static final int SEGUNDOS_MINIMOS = 100; //1 MINUTOS E 40 SEGUNDOS
    private static final int SEGUNDOS_MAXIMOS = 200; // 3 MIN E 20 SEGUNDOS
    private static final int METROS_MINIMOS = 2000; // 2 KM
    private static final int METROS_MAXIMOS = 4000; // 4 KM

    @Override
    public List<LeituraVeiculo> gerarLeituras(int totalLeituras) {
        Random randomizador = new Random();
        List<LeituraVeiculo> leituras = new ArrayList<>();

        for (int i = 0; i < totalLeituras; i++) {
            int tempo = randomizador.nextInt(SEGUNDOS_MAXIMOS - SEGUNDOS_MINIMOS + 1) + SEGUNDOS_MINIMOS;
            int distancia = randomizador.nextInt(METROS_MAXIMOS - METROS_MINIMOS + 1) + METROS_MINIMOS;

            LeituraVeiculo leitura = new LeituraVeiculo(i + 1, tempo, distancia);
            leituras.add(leitura);
        }

        return leituras;
    }
}