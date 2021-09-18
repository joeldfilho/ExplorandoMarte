package com.joel.explorando_marte.service;

import com.joel.explorando_marte.business.ExplorandoMarteBusiness;
import com.joel.explorando_marte.model.Marte;
import com.joel.explorando_marte.model.Sonda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ExplorandoMarteService {

    @Autowired
    ExplorandoMarteBusiness explorandoMarteBusiness;

    public Sonda criaSonda(String entrada) {
        String[] informacoes = entrada.split(" ");
        String direcao = informacoes[2];
        int posicaoX = Integer.parseInt(informacoes[0]);
        int posicaoY = Integer.parseInt(informacoes[1]);
        return new Sonda(posicaoX, posicaoY, direcao);
    }

    public void mudaDirecao(String comando, Sonda sonda) {
        switch (comando){
            case("L"):
                sonda.virarParaEsquerda();
                break;
            case("R"):
                sonda.virarParaDireita();
                break;
            default:
                System.out.println("Direção inválida, aceitável apenas L e R");
        }
    }

    public void moveSonda(Sonda sonda) {
        sonda.mover();
    }

    public Marte leEntrada(String entrada) {
        String[] instrucoes = entrada.split("\n");
        Marte marte = new Marte();
        int[] pontoSuperiorDireito = new int[2];
        String[] pontos = instrucoes[0].split(" ");
        pontoSuperiorDireito[0] = Integer.parseInt(pontos[0]);
        pontoSuperiorDireito[1] = Integer.parseInt(pontos[1]);
        marte.setPlano(explorandoMarteBusiness.geraMatriz(pontoSuperiorDireito));
        for (int i = 1; i < instrucoes.length; i++) {
            if (i%2 != 0){
                marte.adicionaSonda(criaSonda(instrucoes[i]));
            }
            else{
                marte.getSondas().get(marte.getSondas().size() - 1).setComandos(instrucoes[i]);
            }
        }
        return marte;
    }

    public String executaComandosDasSondas(Marte marte) {
        String saida = "";
        for (Sonda sonda: marte.getSondas()
             ) {
            sonda.executarComandos();
            saida += String.valueOf(sonda.getPosicaoX()) + " " + String.valueOf(sonda.getPosicaoY()) + " " + sonda.getDirecao() + "\n";
        }

        return StringUtils.trimTrailingCharacter(saida, '\n');
    }
}
