package com.joel.explorando_marte.service;

import com.joel.explorando_marte.model.Sonda;
import org.springframework.stereotype.Service;

@Service
public class ExplorandoMarteService {

    public Sonda criaSonda(String entrada) {
        String[] informacoes = entrada.split(" ");
        String direcao = informacoes[2];
        int posicaoX = Integer.parseInt(informacoes[0]);
        int posicaoY = Integer.parseInt(informacoes[1]);
        return new Sonda(posicaoX, posicaoY, direcao);
    }
}
