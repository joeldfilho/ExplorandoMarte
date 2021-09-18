package com.joel.explorando_marte.model;


public class Sonda {

    private int posicaoX;
    private int posicaoY;
    private String direcao;
    private String comandos;

    public Sonda(){

    }

    public Sonda(int posicaoX, int posicaoY, String direcao) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.direcao = direcao;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getComandos() {
        return comandos;
    }

    public void setComandos(String comandos) {
        this.comandos = comandos;
    }

    public void virarParaEsquerda() {
        switch (this.direcao){
            case ("N"):
                setDirecao("W");
                break;
            case ("W"):
                setDirecao("S");
                break;
            case("S"):
                setDirecao("E");
                break;
            case("E"):
                setDirecao("N");
                break;
        }
    }

    public void virarParaDireita() {
        switch (this.direcao){
            case ("N"):
                setDirecao("E");
                break;
            case ("E"):
                setDirecao("S");
                break;
            case("S"):
                setDirecao("W");
                break;
            case("W"):
                setDirecao("N");
                break;
        }
    }
}
