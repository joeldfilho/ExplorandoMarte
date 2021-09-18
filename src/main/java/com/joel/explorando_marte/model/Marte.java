package com.joel.explorando_marte.model;

import java.util.ArrayList;

public class Marte {
    public Marte(){
        this.sondas = new ArrayList<>();
    }

    private ArrayList<Sonda> sondas;
    private int[][] plano;
    private int sondaAtual = 0;

    public ArrayList<Sonda> getSondas() {
        return sondas;
    }

    public void setSondas(ArrayList<Sonda> sondas) {
        this.sondas = sondas;
    }

    public int[][] getPlano() {
        return plano;
    }

    public void setPlano(int[][] plano) {
        this.plano = plano;
    }

    public int getSondaAtual() {
        return sondaAtual;
    }

    public void setSondaAtual(int sondaAtual) {
        this.sondaAtual = sondaAtual;
    }


    public void adicionaSonda(Sonda sonda) {
        this.sondas.add(sonda);
    }
}
