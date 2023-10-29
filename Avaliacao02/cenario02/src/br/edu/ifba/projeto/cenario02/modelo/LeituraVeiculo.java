package br.edu.ifba.projeto.cenario02.modelo;
//Classe para simular a leitura do veículo, que de forma geral, é constante O(1).

public class LeituraVeiculo {

    Integer id = 0;
    public Integer segundosGastos = 0;
    public Integer metrosPercorridos = 0;

    public LeituraVeiculo (Integer id, Integer segundosGastos, Integer metrosPercorridos){
        this.id = id;
        this.segundosGastos = segundosGastos;
        this.metrosPercorridos = metrosPercorridos;
    }

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
        this.id = id;
    } 

    public int getSegundosGastos() {
        return segundosGastos;
    }

    public void setSegundosGastos(int segundosGastos) {
        this.segundosGastos = segundosGastos;
    }

    public int getMetrosPercorridos() {
        return metrosPercorridos;
    }
    
    public void setMetrosPercorridos(int metrosPercorridos) {
        this.metrosPercorridos = metrosPercorridos;
    }

    @Override
    public String toString() {
        return "segundosGastos: " + segundosGastos + "metrosPercorridos" + metrosPercorridos + "                                                   ";
    }

}
