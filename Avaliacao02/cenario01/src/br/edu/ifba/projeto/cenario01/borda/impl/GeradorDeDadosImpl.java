package br.edu.ifba.projeto.cenario01.borda.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.projeto.cenario01.borda.sensor.Sensor;
import br.edu.ifba.projeto.cenario01.modelo.LeituraVeiculo;
import br.edu.ifba.projeto.cenario01.modelo.Veiculo;

public class GeradorDeDadosImpl implements Runnable {
    protected String FILIAL = "";
    protected int TOTAL_DE_VEICULOS = 0;
    protected int TOTAL_DE_LEITURAS = 0;
    protected Map<Veiculo, List<LeituraVeiculo>> filial = new TreeMap<>();

    // Complexidade constante O(1)
    public GeradorDeDadosImpl(String FILIAL, int TOTAL_DE_VEICULOS, int TOTAL_DE_LEITURAS) {
        this.FILIAL = FILIAL;
        this.TOTAL_DE_VEICULOS = TOTAL_DE_VEICULOS;
        this.TOTAL_DE_LEITURAS = TOTAL_DE_LEITURAS;
    }
    // Complexidade constante O(1)
    public Map<Veiculo, List<LeituraVeiculo>> getFilial() {
        return filial;
    }
    // Complexidade  linear, O(N)
    public Map<Veiculo, List<LeituraVeiculo>> gerarVeiculos(String filial, int TOTAL_DE_VEICULOS, int TOTAL_DE_LEITURAS) throws InterruptedException {
        List<Thread> executoresGeradoresDeDados = new ArrayList<>();
        Map<Veiculo, Sensor> veiculoSensor = new TreeMap<>();

        Map<Veiculo, List<LeituraVeiculo>> veiculos = new TreeMap<>();

        for (int i = 0; i < TOTAL_DE_VEICULOS; i++) {

            String idVeiculo = (i + 1) + "";
            String placaVeiculo = "Placa #" + idVeiculo;
            Veiculo veiculo = new Veiculo(idVeiculo, placaVeiculo);

            Sensor sensor = new SensorImpl(filial, placaVeiculo, TOTAL_DE_LEITURAS);
            Thread executor = new Thread(sensor);
            executoresGeradoresDeDados.add(executor);
            veiculoSensor.put(veiculo, sensor);
            executor.start();
        }

        for (Thread executor : executoresGeradoresDeDados) {
            executor.join();
        }

        for (Map.Entry<Veiculo, Sensor> entry : veiculoSensor.entrySet()) {
            Veiculo veiculo = entry.getKey();
            Sensor sensor = entry.getValue();
            veiculos.put(veiculo, sensor.getLeituras());
        }
        return veiculos;
    }
    // Complexidade  linear, O(N)
    @Override
    public void run() {
        try {
            filial = this.gerarVeiculos(FILIAL, TOTAL_DE_VEICULOS, TOTAL_DE_LEITURAS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
