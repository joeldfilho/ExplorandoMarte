package com.joel.explorando_marte.model;


import com.joel.explorando_marte.exception.EntradaInvalidaException;

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

    public void executarComandos() {
        String[] comandos = this.comandos.split("");
        for (String comando: comandos
             ) {
            if (comando.equals("L")){
                virarParaEsquerda();
            }else if(comando.equals("R")){
                virarParaDireita();
            }else if(comando.equals("M")){
                mover();
            }else{
                throw new EntradaInvalidaException("Comando inv??lido. S??o aceitos apenas os omandos \"L\", \"R\" e \"M\"");
            }
        }

    }

    public void mover() {
        switch (this.getDirecao()){
            case("N"):
                this.setPosicaoY(this.getPosicaoY() + 1);
                break;
            case("E"):
                this.setPosicaoX(this.getPosicaoX() + 1);
                break;
            case("S"):
                this.setPosicaoY(this.getPosicaoY() - 1);
                break;
            case("W"):
                this.setPosicaoX(this.getPosicaoX() - 1);
                break;
        }
    }

    public void atualizaPosicaoParaOPlano(int[][] plano) {
        while(posicaoX >= plano.length){
            posicaoX -= plano.length;
        }
        while(posicaoX < 0){
            posicaoX += plano.length;
        }
        while (posicaoY >= plano[0].length){
            posicaoY -= plano[0].length;
        }
        while (posicaoY < 0){
            posicaoY += plano[0].length;
        }
    }
}
