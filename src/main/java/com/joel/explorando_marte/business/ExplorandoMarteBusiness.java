package com.joel.explorando_marte.business;

import org.springframework.stereotype.Service;

@Service
public class ExplorandoMarteBusiness {

    public int[][] geraMatriz(int[] pontoSuperiorDireito) {
        int[][] matriz = new int[pontoSuperiorDireito[0]][pontoSuperiorDireito[1]];
        for (int i = 0; i < pontoSuperiorDireito[0]; i++) {
            for (int j = 0; j < pontoSuperiorDireito[1]; j++) {
                matriz[i][j] = 0;
            }
        }
        return matriz;
    }
}
