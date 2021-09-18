package com.joel.explorando_marte.business;

import org.springframework.stereotype.Service;

@Service
public class ExplorandoMarteBusiness {

    public int[][] geraMatriz(int[] pontoSuperiorDireito) {
        return new int[pontoSuperiorDireito[0]][pontoSuperiorDireito[1]];
    }
}
