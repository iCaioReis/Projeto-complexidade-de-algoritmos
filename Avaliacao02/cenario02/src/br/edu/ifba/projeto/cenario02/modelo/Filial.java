package br.edu.ifba.projeto.cenario02.modelo;
//Classe para simular as filiais, que de forma geral, é constante O(1).

public class Filial implements Comparable<Filial>{
    private String id;
    private String nome;

    public Filial(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public int compareTo(Filial outraFilial) {
        return this.getId().compareTo(outraFilial.getId());
    }
}
