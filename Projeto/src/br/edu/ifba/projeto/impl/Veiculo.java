package br.edu.ifba.projeto.impl;

public class Veiculo implements Comparable<Veiculo>{
    private String id;
    private String placa;

    public Veiculo(String id, String placa) {
        this.id = id;
        this.placa = placa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


    @Override
    public String toString() {
        return "Id: " + id + ", Placa: " + placa;
    }
    @Override
    public int compareTo(Veiculo outroPaciente) {
        return this.getId().compareTo(outroPaciente.getId());
    }
}