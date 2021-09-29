package com.joel.explorando_marte.business;

import com.joel.explorando_marte.model.Sonda;
import org.springframework.stereotype.Service;

@Service
public class ExplorandoMarteBusiness {

    public int[][] geraMatriz(int[] pontoSuperiorDireito) {
        int[][] matriz = new int[pontoSuperiorDireito[0]+1][pontoSuperiorDireito[1]+1];
        for (int i = 0; i < pontoSuperiorDireito[0]; i++) {
            for (int j = 0; j < pontoSuperiorDireito[1]; j++) {
                matriz[i][j] = 0;
            }
        }
        return matriz;
    }

    public boolean sondaEstaDentroDoPlano(Sonda sonda, int[][] matriz) {
        if(sonda.getPosicaoX() < 0 | sonda.getPosicaoY() < 0){
            return false;
        }
        if (sonda.getPosicaoX() > matriz.length){
            return false;
        }
        if (sonda.getPosicaoY() > matriz[0].length){
            return false;
        }
        return true;
    }

}
