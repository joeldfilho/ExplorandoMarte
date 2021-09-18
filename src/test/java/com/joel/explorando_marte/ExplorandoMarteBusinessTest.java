package com.joel.explorando_marte;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ExplorandoMarteBusinessTest {

    /*
    * Dado um ponto (x,y) criar uma matriz que vai de (0,0) a (x,y)
    * */
    @Test
    public void criaPlanoMarteTest(int[] pontoSuperiorDireito){
        ExplorandoMarteBusiness explorandoMarteBusiness = new ExplorandoMarteBusiness();
        int[][] matriz = explorandoMarteBusiness.geraMatriz(pontoSuperiorDireito);
    }
}
